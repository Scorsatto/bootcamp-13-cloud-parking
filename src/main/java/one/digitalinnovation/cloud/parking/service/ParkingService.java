package one.digitalinnovation.cloud.parking.service;

import one.digitalinnovation.cloud.parking.exception.ParkingNotFoundException;
import one.digitalinnovation.cloud.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id = getUUID();
        var id2 = getUUID();
        Parking parking = new Parking(id, "DMS-1111", "SC", "Celta", "Preto");
        Parking parking2 = new Parking(id2, "ASD-222", "MT", "Gol", "Branco");
        parkingMap.put(id, parking);
        parkingMap.put(id2, parking2);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);

        if (parking == null) {
            throw new ParkingNotFoundException(id);
        }

        return parking;
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();

        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);

        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parking);
        return parking;
    }

    public Parking exit(String id) {
        return null;
    }
}
