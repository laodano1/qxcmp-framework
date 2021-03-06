package com.qxcmp.framework.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
interface SystemDictionaryItemRepository extends JpaRepository<SystemDictionaryItem, Long>, JpaSpecificationExecutor<SystemDictionaryItem> {
}
