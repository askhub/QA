package aero.s7.jl.autotest.common;

import java.util.Arrays;
import java.util.List;

public class Constant {
    public static final String LOGIN_NAME = "a.korotchenko";
    public static final String LOGIN_PASS = "1234567";
    public static final String LOGIN_NAME_WRONG = "a.korotko";
    public static final String LOGIN_PASS_WRONG = "abcdefg";
    public static final String BASE_DEV_URL = "https://jl-dev.s7.aero";
    public static final String BASE_UAT_URL = "https://jl-uat.s7.aero";

    public static class Api {
        public static final int SEAT_RULE_ID = 250;
        public static final String API_GET_CATEGORY = "https://jl-dev.s7.aero/api/configuration/doc-category";
        public static final int SEARCH_SR_BY_AIRCRAFT = 63;
        public static final int DOCUMENT_ID = 300;
    }

    public static class Ui {

        public static final String E_MAIL = "akorotchenko@underdog.team";
        public static final String TYPE_1 = "Trainer";
        public static final String TYPE_2 = "Trainee";
        public static final String CREATE_RULE_CARRIER = "S7";
        public static final String CREATE_RULE_AIRCRAFT = "Boeing 737-800 (winglets) pax";
        public static final String CREATE_RULE_TRAINER_CODE = "9";
        public static final String CREATE_RULE_TRAINEE_CODE = "@";
        public static final String SEARCH_RULE_AIRCRAFT = "Airbus A321";
        public static final String SEARCH_DOC_NAME = "Сертификат";
        public static final String SEARCH_DOC_TYPE = "STATIC";
        public static final String[] SEARCH_DOC_OWNER = new String[]{"ЛД", "ДОПП"};
        public static final String SEARCH_DOC_CATEGORY = "Основные документы";
        public static final String SEARCH_DOC_AUTHOR = "Коротченко";
        public static final String SEARCH_RULE_CODE = "G";
        public static final String SEARCH_RULE_CARRIER = "GH";
        public static final String SEAT_RULE_CODE = "k";
        public static final String SEAT_RULE_ROLE = "PIC";
        public static final String SEAT_RULE_POSITION = "LS";
        public static final String NEW_CATEGORY_NAME = "Тестовая категория";
        public static final String PARENT_CATEGORY_NAME = "Test-2";
        public static final String CHILD_CATEGORY_NAME = "child-1 for test-2";
        public static final String DATE_FROM_TD_TS = "01052023";
        public static final String DATE_TO_TD_TS = "31122023";
        public static final String CDV_NUMBER = "01052023/052023/3182023";
        public static final String CDV_NUMBER_WRONG = "01052023/052023";
        public static final String SEARCH_LEG_FLIGHT_NUMBER = "5226";
        public static final String SEARCH_LEG_CREW = "FD";
        public static final String SEARCH_LEG_DATE = "01092023";
        public static final String SEARCH_LEG_DEP_AIRPORT = "OVB";
        public static final String SEARCH_LEG_ARR_AIRPORT = "AER";
        public static final String SEARCH_LEG_CARRIER = "S7";
        public static String[] UNIQUE_CODES = {"F","GG","f","ff","1","11","#","##","G-","w-","Д","ДД","б","бб","L2","z1","L#","z#","JЩ","Gч","iЖ","qш","И2","л3","Э%","э%"};
        public static final List<String> UNIQUE_CODE_LIST = Arrays.asList(UNIQUE_CODES);
        public static final String TOAST_SEAT_RULE_CREATED = "Seat rule created";
        public static final String TOAST_SEAT_RULE_UPDATED = "Seat rule updated";
        public static final String TOAST_SEAT_RULE_DELETED = "Seat rule deleted";
        public static final String TOAST_SEAT_RULE_TASK_DELETED = "Task deleted";
        public static final String TOAST_SEAT_RULE_RECOVERED = "Seat rule recovered";
        public static final String TOAST_SEAT_RULE_OUT_OF_DATE_RECOVERED = "Seat rule can not be recovered: out of date";
        public static final String TOAST_SEAT_RULE_TRAINER_CODE_CONTROL = "Only upper case case are allowed";
        public static final String TOAST_SEAT_RULE_TRAINEE_CODE_CONTROL = "Only lower case case are allowed";
        public static final String TOAST_SEAT_RULE_LENGTH_CODE_CONTROL = "Maximum length is 1 character";
        public static final String TOAST_REQUIRED_FIELD = "Required field";
        public static final String TOAST_SEAT_RULE_MEMBER_TYPE_CONTROL = "Task must contain one Trainee and one Trainer";
        public static final String TOAST_DOCUMENT_CREATED = "Document created";
        public static final String TOAST_DOCUMENT_UPDATED = "Document updated";
        public static final String TOAST_DOCUMENT_DELETED = "Document deleted";
        public static final String TOAST_DOCUMENT_RULE_CONTROL = "Doc need to have at least 1 rule";
        public static final String TOAST_DOCUMENT_ATTACHMENT_LIMIT = "File is too large 50 Mb";
        public static final String TOAST_DOC_RULE_CREATED = "Doc rule created";
        public static final String TOAST_DOC_RULE_UPDATED = "Doc rule updated";
        public static final String TOAST_DOC_RULE_DELETED = "Doc rule deleted";

        static String[] POSITION_TEST = {"LS", "RS", "JS1", "JS2", "S1", "S2", "S3", "S4"};
        public static final List<String> POSITION_TEST_LIST = Arrays.asList(POSITION_TEST);

    }

    public static class Dictionary {
        static String[] CREW_TYPE = {"ALL", "FD", "CC"};
        static String[] CREW_CAT = {"cat 1", "cat 2", "cat 3", "cat 4", "cat 5", "cat 6"};
        static String[] CREW_POSITION = {"LS", "RS", "JS", "JS", "S", "S", "S", "S", "RLS", "LRS", "JLS", "JLS", "JRS", "JRS", "RJS", "LJS"};
        static String[] CREW_QUALIFICATION = {"CFI", "CP", "CPrh", "TRE", "FO"};
        static String [] CREW_ROLE = {"PIC", "SP", "RP"};
        static String [] CREW_SUB_TASK = {"PICUS", "LE", "LTC"};
        static String[] MEMBER_TYPE = {"Trainer", "Trainee", "Member"};

        public static final List<String> CREW_MEMBER_TYPE = Arrays.asList(CREW_TYPE);
        public static final List<String> CREW_CATEGORY = Arrays.asList(CREW_CAT);
        public static final List<String> POSITION = Arrays.asList(CREW_POSITION);
        public static final List<String> QUALIFICATION = Arrays.asList(CREW_QUALIFICATION);
        public static final List<String> ROLE = Arrays.asList(CREW_ROLE);
        public static final List<String> SUB_TASK = Arrays.asList(CREW_SUB_TASK);
        public static final List<String> TYPE = Arrays.asList(MEMBER_TYPE);
    }
}
