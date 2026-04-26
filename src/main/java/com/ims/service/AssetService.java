package com.ims.service;

import com.ims.model.Asset;
import com.ims.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AssetService {

    @Autowired
    private AssetRepository repo;

    public List<Asset> findAll() { return repo.findAll(); }

    @SuppressWarnings("null")
    public Optional<Asset> findById(Long id) { return repo.findById(id); }

    public List<Asset> findByStatus(String status) { return repo.findByStatus(status); }
    
    public List<Asset> findByDeviceType(String deviceType) { return repo.findByDeviceType(deviceType); }

    public List<Asset> findByDepartment(String department) { return repo.findByDepartment(department); }

    public long count() { return repo.count(); }

    public long countAll() { return repo.count(); }

    public long countByStatus(String status) { return repo.countByStatus(status); }

    public long countByType(String type) { return repo.countByDeviceType(type); }

    @SuppressWarnings("null")
    public Asset save(Asset asset) { return repo.save(asset); }

    @SuppressWarnings("null")
    public void deleteById(Long id) { repo.deleteById(id); }

    public boolean existsByAssetTag(String assetTag) { return repo.existsByAssetTag(assetTag); }

    public List<Asset> search(String keyword) {
        return repo.findByAssetTagContainingIgnoreCaseOrBrandContainingIgnoreCaseOrModelContainingIgnoreCase(keyword, keyword, keyword);
    }

    public List<Asset> findAvailable() {
        return repo.findByStatus("Available");
    }
}