package com.ims.repository;

import com.ims.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    Optional<Asset> findByAssetTag(String assetTag);
    List<Asset> findByDeviceType(String deviceType);
    List<Asset> findByStatus(String status);
    List<Asset> findByDepartment(String department);
    List<Asset> findByCondition(String condition);
    List<Asset> findByAssetTagContainingIgnoreCaseOrBrandContainingIgnoreCaseOrModelContainingIgnoreCase(
        String tag, String brand, String model);
    long countByStatus(String status);
    long countByDeviceType(String type);
    boolean existsByAssetTag(String assetTag);
}