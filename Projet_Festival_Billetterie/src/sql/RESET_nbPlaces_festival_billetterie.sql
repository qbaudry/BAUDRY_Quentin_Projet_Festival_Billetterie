UPDATE Representation r
INNER JOIN Lieu l ON r.id_lieu=l.id
SET nbPlace = l.capacite
WHERE r.id_lieu=l.id