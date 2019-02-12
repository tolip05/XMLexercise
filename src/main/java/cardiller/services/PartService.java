package cardiller.services;

import cardiller.domein.enteties.Part;
import cardiller.domein.enteties.dtos.PartImportRootDto;

import java.util.List;

public interface PartService {
    void importParts(PartImportRootDto partImportRootDto);
    List<Part> getRandomParts();
}
