package aero.s7.jl.autotest.api.Documents;

import aero.s7.jl.autotest.api.DictionaryAndData.*;
import aero.s7.jl.autotest.api.Filter.DocumentsPackingSearch;

import java.util.List;

public interface DocumentsPackingService {
    DocumentsPacking getDocument (int id);
    DocumentsPacking createDocumentWithRule (DocTemplateWithRulesCreateForm form);
    int createEmptyDocument (DocTemplateWithRulesCreateForm form);
    DocumentsPacking updateDocument (DocTemplateUpdateForm form);
    DocRule updateDocRule (DocRuleUpdateForm form);
    boolean deleteDocument (int id);
    DocRule getDocRule (int docId);
    List<DocTemplateData> searchDocument (DocumentsPackingSearch documentsPackingSearch);
    List<DocTemplateData> sortDocuments (DocumentsPackingSearch documentsPackingSearch, String sortField, String sortDirection);
    List<Airlines> getAirlines ();
    List<Aircrafts> getAircrafts ();
    List<Boards> getBoards ();
    List<Countries> getCountries ();
    List<Airports> getAirports ();
    List<DocCategories> getCategories ();
    List<DocOwners> getOwners ();
    List<CrewRouteCategories> getCrewRouteCategories ();
}
