package aero.s7.jl.autotest.api.DocumentsPacking;

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
}
