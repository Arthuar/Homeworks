SELECT members.first_name, members.last_name, members.mail, members.allow2drive, members.ownership, building.id AS numberOfBuilding, building.adress AS adressOfBuilding, flat.flat_number, flat.flat_area  
FROM flat 
INNER JOIN members ON members.id_flat = flat.id
INNER JOIN building ON flat.id_building = building.id
WHERE allow2drive = '0' and ownership = '1';