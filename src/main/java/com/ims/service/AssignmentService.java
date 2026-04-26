package com.ims.service;

import com.ims.model.Asset;
import com.ims.model.Assignment;
import com.ims.repository.AssetRepository;
import com.ims.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository repo;

    @Autowired
    private AssetRepository assetRepo;

    public List<Assignment> findAll() {
        return repo.findAll();
    }

    public List<Assignment> findByStatus(String status) {
        return repo.findByStatus(status);
    }

    @SuppressWarnings("null")
    public Optional<Assignment> findById(Long id) {
        return repo.findById(id);
    }

    public long count() {
        return repo.count();
    }

    public long countByStatus(String status) {
        return repo.countByStatus(status);
    }

    public long countActive() {
        return repo.countByStatus("Active");
    }

    public List<Assignment> findActive() {
        return repo.findByStatus("Active");
    }

    public Assignment save(Assignment assignment) {
        return repo.save(assignment);
    }

    @Transactional
    public Assignment issueAsset(Long assetId, Assignment assignmentDetails) {
        // 1. Find the asset by its ID
        Asset asset = assetRepo.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found with ID: " + assetId));

        // 2. Check if the asset is available
        if (!"Available".equalsIgnoreCase(asset.getStatus())) {
            throw new RuntimeException("Asset is not available for assignment. Current status: " + asset.getStatus());
        }

        // 3. Update the asset's status to "Assigned" and save it
        asset.setStatus("Assigned");
        assetRepo.save(asset);

        // 4. Set up the new assignment record
        assignmentDetails.setAsset(asset);
        assignmentDetails.setIssuedDate(LocalDate.now());
        assignmentDetails.setStatus("Active");

        // 5. Save the new assignment
        return repo.save(assignmentDetails);
    }

    @Transactional
    public void returnAsset(Long assignmentId, String returnCondition, String returnNotes) {
        // Find the assignment
        Assignment assignment = findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found with ID: " + assignmentId));

        // Update the asset's status back to "Available"
        Asset asset = assignment.getAsset();
        asset.setStatus("Available");
        asset.setCondition(returnCondition); // Update the asset's general condition
        assetRepo.save(asset);

        // Update the assignment record
        assignment.setStatus("Returned");
        assignment.setReturnedDate(LocalDate.now());
        assignment.setConditionAtReturn(returnCondition);
        assignment.setReturnNotes(returnNotes);
        repo.save(assignment);
    }
}