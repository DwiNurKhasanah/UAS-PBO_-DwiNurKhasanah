CREATE DATABASE IF NOT EXISTS hero_db;
USE hero_db;

CREATE TABLE IF NOT EXISTS tm_hero (
    id_hero INT AUTO_INCREMENT PRIMARY KEY,
    nama_hero VARCHAR(100) NOT NULL,
    kategori ENUM('MAGE', 'ASSASIN', 'FIGHTER', 'TANK', 'MARKSMAN', 'SUPPORT') NOT NULL,
    gender ENUM('MALE', 'FEMALE') NOT NULL
);

-- Contoh data (opsional)
INSERT INTO tm_hero(nama_hero, kategori, gender) VALUES
('Layla', 'MARKSMAN', 'FEMALE'),
('Zilong', 'FIGHTER', 'MALE');
