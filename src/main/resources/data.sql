-- Delete existing data
DELETE FROM assignments;
DELETE FROM assets;
DELETE FROM sys_admin;

-- Insert SysAdmin with BCRYPT-ENCODED password (password is "24RP06926")
INSERT INTO sys_admin (id, username, password, full_name, role, enabled) 
VALUES (1, '24RP09739', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxGNCmGBCZt.', 'NDIKUMANA DERIC', 'SYSADMIN', TRUE);

-- Insert sample assets
INSERT INTO assets (asset_tag, device_type, brand, model, serial_number, processor, ram, storage, operating_system, asset_condition, asset_status, department, location, purchase_date, created_at) 
VALUES ('AIR-LT-001', 'LAPTOP', 'Dell', 'Latitude 5420', 'SN123456', 'Intel Core i5-1135G7', '16GB', '512GB SSD', 'Windows 11 Pro', 'GOOD', 'AVAILABLE', 'IT', 'Kigali HQ', '2024-01-15', CURRENT_DATE);

INSERT INTO assets (asset_tag, device_type, brand, model, serial_number, processor, ram, storage, operating_system, asset_condition, asset_status, department, location, purchase_date, created_at) 
VALUES ('AIR-DT-002', 'DESKTOP', 'HP', 'EliteDesk 800', 'SN789012', 'Intel Core i7-10700', '32GB', '1TB SSD', 'Windows 11 Pro', 'NEW', 'AVAILABLE', 'Finance', 'Kigali HQ', '2024-02-20', CURRENT_DATE);

INSERT INTO assets (asset_tag, device_type, brand, model, serial_number, processor, ram, storage, operating_system, asset_condition, asset_status, department, location, purchase_date, created_at) 
VALUES ('AIR-MB-003', 'MOBILE', 'Samsung', 'Galaxy S23', 'IMSI789012', 'Snapdragon 8 Gen 2', '8GB', '256GB', 'Android 14', 'NEW', 'AVAILABLE', 'Sales', 'Kigali HQ', '2024-03-10', CURRENT_DATE);

-- Verify data
SELECT 'Admin created with plain text password' as Status;
SELECT username, password, full_name FROM sys_admin;