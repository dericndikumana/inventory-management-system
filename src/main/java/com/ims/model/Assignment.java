package com.ims.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @NotBlank(message = "Employee name is required")
    private String assignedTo;

    private String employeeId;
    private String department;
    private String phoneNumber;

    private LocalDate issuedDate;
    private LocalDate expectedReturnDate;
    private LocalDate returnedDate;

    private String conditionAtIssue;
    private String conditionAtReturn;

    @Column(length = 500)
    private String purposeOfUse;

    @Column(length = 500)
    private String returnNotes;

    private String issuedBy;
    private String status;

    @PrePersist
    protected void onCreate() {
        this.issuedDate = LocalDate.now();
        if (this.status == null) this.status = "ACTIVE";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Asset getAsset() { return asset; }
    public void setAsset(Asset asset) { this.asset = asset; }
    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public LocalDate getIssuedDate() { return issuedDate; }
    public void setIssuedDate(LocalDate issuedDate) { this.issuedDate = issuedDate; }
    public LocalDate getExpectedReturnDate() { return expectedReturnDate; }
    public void setExpectedReturnDate(LocalDate expectedReturnDate) { this.expectedReturnDate = expectedReturnDate; }
    public LocalDate getReturnedDate() { return returnedDate; }
    public void setReturnedDate(LocalDate returnedDate) { this.returnedDate = returnedDate; }
    public String getConditionAtIssue() { return conditionAtIssue; }
    public void setConditionAtIssue(String conditionAtIssue) { this.conditionAtIssue = conditionAtIssue; }
    public String getConditionAtReturn() { return conditionAtReturn; }
    public void setConditionAtReturn(String conditionAtReturn) { this.conditionAtReturn = conditionAtReturn; }
    public String getPurposeOfUse() { return purposeOfUse; }
    public void setPurposeOfUse(String purposeOfUse) { this.purposeOfUse = purposeOfUse; }
    public String getReturnNotes() { return returnNotes; }
    public void setReturnNotes(String returnNotes) { this.returnNotes = returnNotes; }
    public String getIssuedBy() { return issuedBy; }
    public void setIssuedBy(String issuedBy) { this.issuedBy = issuedBy; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}