package com.qxcmp.framework.domain;

import com.qxcmp.framework.config.SystemConfigService;
import com.qxcmp.framework.core.QXCMPConfigurator;
import com.qxcmp.framework.core.QXCMPSystemConfigConfiguration;
import com.qxcmp.framework.core.entity.AbstractEntityService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.List;

@Service
public class RegionService extends AbstractEntityService<Region, String, RegionRepository> implements QXCMPConfigurator {

    private final SystemConfigService systemConfigService;

    public RegionService(RegionRepository repository, SystemConfigService systemConfigService) {
        super(repository);
        this.systemConfigService = systemConfigService;
    }

    public List<Region> findByLevel(RegionLevel level) {
        return repository.findByLevel(level);
    }

    public List<Region> findInferiors(Region region) {
        return repository.findInferiors(region.getCode());
    }

    public List<Region> findInferiors(String parent) {
        return repository.findInferiors(parent);
    }

    public List<Region> findAllInferiors(Region region) {
        return repository.findAllInferiors(region.getCode());
    }

    public List<Region> findAllInferiors(String parent) {
        return repository.findAllInferiors(parent);
    }

    @Override
    protected <S extends Region> String getEntityId(S entity) {
        return entity.getCode();
    }

    @Override
    public void config() throws Exception {
        if (!systemConfigService.getBoolean(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_REGION_INITIAL_FLAG).orElse(false)) {
            reload();
            systemConfigService.update(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_REGION_INITIAL_FLAG, "true");
        }
    }

    @Override
    public int order() {
        return Integer.MIN_VALUE + 4;
    }

    public void reload() {
        try {
            Resource areaFile = new ClassPathResource("/district/District.csv");

            CSVFormat.EXCEL.parse(new InputStreamReader(areaFile.getInputStream())).forEach(record -> {

                if (record.getRecordNumber() == 1) {
                    return;
                }

                try {
                    String id = record.get(0);
                    String name = record.get(1);

                    if (!findOne("86").isPresent()) {
                        create(() -> {
                            Region region = next();
                            region.setCode("86");
                            region.setLevel(RegionLevel.STATE);
                            region.setName("中国");
                            return region;
                        });
                    }

                    if (!findOne(id).isPresent()) {
                        Region region = next();

                        region.setCode(id);
                        region.setName(name);

                        if (StringUtils.endsWith(id, "0000")) {
                            region.setLevel(RegionLevel.PROVINCE);
                            region.setParent("86");
                        } else if (StringUtils.endsWith(id, "00")) {
                            region.setLevel(RegionLevel.CITY);
                            region.setParent(StringUtils.substring(id, 0, 2) + "0000");
                        } else {
                            region.setLevel(RegionLevel.COUNTY);
                            region.setParent(StringUtils.substring(id, 0, 4) + "00");
                        }

                        create(() -> region);
                    }

                } catch (NumberFormatException ignored) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
