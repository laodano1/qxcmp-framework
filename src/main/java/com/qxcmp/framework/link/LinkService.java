package com.qxcmp.framework.link;

import com.qxcmp.framework.core.entity.AbstractEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService extends AbstractEntityService<Link, Long, LinkRepository> {
    public LinkService(LinkRepository repository) {
        super(repository);
    }

    public Optional<Link> findOne(String id) {
        try {
            return findOne(Long.parseLong(id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Link> findByType(String type) {
        return repository.findByTypeOrderBySort(type);
    }

    @Override
    protected <S extends Link> Long getEntityId(S entity) {
        return entity.getId();
    }
}
