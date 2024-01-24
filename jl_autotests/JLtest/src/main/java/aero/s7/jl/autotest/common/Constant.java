package aero.s7.jl.autotest.common;

import java.util.Arrays;
import java.util.List;

public class Constant {
    public static final String LOGIN_NAME = "as.korotko";
    public static final String LOGIN_PASS = "e2e4e6e8e10";
    public static final String LOGIN_NAME_WRONG = "a.korotko";
    public static final String LOGIN_PASS_WRONG = "abcdefg";
    public static final String BASE_URL = "https://jl-dev.s7.aero"; //"https://jl-uat.s7.aero";

    public static class Api {
        public static final int SEAT_RULE_ID = 250;
        public static final String API_GET_CATEGORY = "https://jl-dev.s7.aero/api/configuration/doc-category";
        public static final int SEARCH_SR_BY_AIRCRAFT = 63;
        public static final int DOCUMENT_ID = 300;
    }

    public static class Ui {
        public static final int SHORT_PAUSE = 500;
        public static final int MIDDLE_PAUSE = 3000;
        public static final int LONG_PAUSE = 5000;
        public static final String E_MAIL = "askorotko@kotelov.team";
        public static final String TOAST_SEND_MESSAGE = "Flight task successfully sent";
        public static final String TYPE_1 = "Trainer";
        public static final String TYPE_2 = "Trainee";
        public static final int MAX_GENERAL_CREW_MEMBER = 6;
        public static final int MAX_ADDITIONAL_CREW_MEMBER = 2;
        public static final String CREATE_RULE_CARRIER = "S7";
        public static final String CREATE_RULE_AIRCRAFT = "Boeing 737-800 (winglets) pax";
        public static final String CREATE_RULE_TRAINER_CODE = "9";
        public static final String CREATE_RULE_TRAINEE_CODE = "@";
        public static final String SEARCH_RULE_AIRCRAFT = "Airbus A320neo";
        public static final String SEARCH_DOC_NAME = "Сертификат";
        public static final String SEARCH_DOC_TYPE = "Dynamic";
        public static final String[] SEARCH_DOC_OWNER = new String[]{"ЛД", "ДОПП"};
        public static final String SEARCH_DOC_CATEGORY = "Основные документы";
        public static final String SEARCH_DOC_AUTHOR = "Коротченко";
        public static final String SEARCH_DOC_MODIFIER = "Коротченко";
        public static final String SEARCH_RULE_CODE = "G";
        public static final String SEARCH_RULE_CARRIER = "GH";
        public static final String SEAT_RULE_CODE = "k";
        public static final String SEAT_RULE_ROLE = "PIC";
        public static final String SEAT_RULE_POSITION = "LS";
        public static final String PAGINATION_PAGE_SIZE = "50";
        public static final String NEW_CATEGORY_NAME = "Тестовая категория";
        public static final String PARENT_CATEGORY_NAME = "Test-1";
        public static final String PARENT_CATEGORY_NAME_2 = "Test-3";
        public static final String PARENT_CATEGORY_NAME_3 = "Test-4";
        public static final String PARENT_CATEGORY_NAME_DELETE = "TestForDelete";
        public static final String PARENT_CATEGORY_NAME_DELETE_2 = "TestForDelete4";
        public static final String PARENT_CATEGORY_DELETE_NEGATIVE_1 = "ParentCatForDelete1";
        public static final String PARENT_CATEGORY_DELETE_NEGATIVE_2 = "ParentCatForDelete2";
        public static final String PARENT_CATEGORY_DELETE_NEGATIVE_3 = "ParentCatForDelete3";
        public static final String PARENT_CATEGORY_DELETE_NEGATIVE_4 = "ParentCatForDelete4";
        public static final String CHILD_CATEGORY_NAME = "child-1 for deleteTest";
        public static final String CHILD_CATEGORY_NAME_2 = "child-22 for deleteTest";
        public static final String CHILD_CATEGORY_NAME_3 = "child-3 for deleteTest";
        public static final String CHILD_CATEGORY_DELETE_NEGATIVE_2 = "ChildCatForDelete2";
        public static final String CHILD_CATEGORY_DELETE_NEGATIVE_3 = "ChildCatForDelete3";
        public static final String CHILD_CATEGORY_DELETE_NEGATIVE_4 = "ChildCatForDelete4";
        public static final String DATE_FROM_CDV = "01052023";
        public static final String DATE_TO_CDV = "31122023";
        public static final String DATE_FROM_CDV_2 = "05052023";
        public static final String DATE_TO_CDV_2 = "31052023";
        public static final String DATE_FROM_CDV_UPDATE = "01062023";
        public static final String DATE_TO_CDV_WRONG = "30042023";
        public static final String CDV_NUMBER = "01052023/052023/3182036";
        public static final String CDV_NUMBER_UPDATE = "01012023/192024/1222999";
        public static final String CDV_NUMBER_WRONG = "01052023/052023/123456";
        public static final String SEARCH_LEG_FLIGHT_NUMBER = "5226";
        public static final String SEARCH_LEG_CREW = "FD";
        public static final String SEARCH_LEG_DATE = "01082023";
        public static final String SEARCH_LEG_DEP_AIRPORT = "OVB";
        public static final String SEARCH_LEG_ARR_AIRPORT = "AER";
        public static final String SEARCH_LEG_CARRIER = "S7";
        public static final String UPPER_DATE_LIMIT = "31.12.2100";
        public static final String LOWER_DATE_LIMIT = "01.01.2000";
        public static final String DOC_NAME_255 = "ЭтоТекст255знаков-ЭтоТекст255знаков-ЭтоТекст255знаков-" +
                "ЭтоТекст255знаков-ЭтоТекст255знаков-ЭтоТекст255знаков-ЭтоТекст255знаков-ЭтоТекст255знаков-" +
                "ЭтоТекст255знаков-ЭтоТекст255знаков-ЭтоТекст255 знаков-ЭтоТекст255 знаков-" +
                "ЭтоТекст255 знаков-ЭтоТекст255 знаков";
        public static final String DOC_NAME_256 = "ЭтоТекст256знаков-ЭтоТекст256знаков-ЭтоТекст256знаков-" +
                "ЭтоТекст256знаков-ЭтоТекст256знаков-ЭтоТекст256знаков-ЭтоТекст256знаков-ЭтоТекст256знаков-" +
                "ЭтоТекст256знаков-ЭтоТекст256знаков-ЭтоТекст256 знаков-ЭтоТекст256 знаков-" +
                "ЭтоТекст256 знаков-ЭтоТекст256 знаков-";
        public static final String WRONG_DOC_NAME_SYMBOLS = "#< $+%>`&*|{=}/@";
        public static final String WRONG_DOC_NAME_PUNCTUATION = ",.!?:;";
        public static final String TEXT_FOR_DESCRIPTION_100 = "ЭтоТекст100знаков-ЭтоТекст100знаков-ЭтоТекст100знаков" +
                "-ЭтоТекст100знаков-ЭтоТекст100знаков-ЭтоТекст10";
        public static final String TEXT_FOR_DESCRIPTION_101 = "ЭтоТекст101знаков-ЭтоТекст101знаков-ЭтоТекст101знаков" +
                "-ЭтоТекст101знаков-ЭтоТекст101знаков-ЭтоТекст101";

        public static String[] UNIQUE_CODES = {"F", "GG", "f", "ff", "1", "11", "#", "##", "G-", "w-", "Д", "ДД",
                                "б", "бб", "L2", "z1", "L#", "z#", "JЩ", "Gч", "iЖ", "qш", "И2", "л3", "Э%", "э%"};
        public static final List<String> UNIQUE_CODE_LIST = Arrays.asList(UNIQUE_CODES);

        public static final String TOAST_SEAT_RULE_CREATED = "Seat rule created";
        public static final String TOAST_SEAT_RULE_UPDATED = "Seat rule updated";
        public static final String TOAST_SEAT_RULE_DELETED = "Seat rule deleted";
        public static final String TOAST_SEAT_RULE_TASK_DELETED = "Task deleted";
        public static final String TOAST_SEAT_RULE_RECOVERED = "Seat rule recovered";
        public static final String TOAST_SEAT_RULE_CANNOT_RECOVERED = "Seat rule can not be recovered: out of date";
        public static final String SEAT_RULE_TRAINER_CODE_CONTROL = "Only upper case case are allowed";
        public static final String SEAT_RULE_TRAINEE_CODE_CONTROL = "Only lower case case are allowed";
        public static final String SEAT_RULE_LENGTH_CODE_CONTROL = "Maximum length is 1 character";
        public static final String REQUIRED_FIELD = "Required field";
        public static final String TOAST_SEAT_RULE_MEMBER_TYPE_CONTROL = "Task must contain one Trainee and one Trainer";
        public static final String TOAST_DOCUMENT_CREATED = "Document created";
        public static final String TOAST_DOCUMENT_UPDATED = "Document updated";
        public static final String TOAST_DOCUMENT_DELETED = "Document deleted";
        public static final String TOAST_DOCUMENT_RULE_CONTROL = "Doc need to have at least 1 rule";
        public static final String TOAST_DOCUMENT_ATTACHMENT_LIMIT = "File is too large 50 Mb";
        public static final String TOAST_DOCUMENT_NAME_LENGTH = "Maximum length — 255";
        public static final String TOAST_DOCUMENT_DESCRIPTION_LENGTH = "Maximum length — 100";
        public static final String TOAST_WRONG_FILE_ATTACHMENT = "Wrong file type";
        public static final String TOAST_DOCUMENT_CANNOT_RECOVERED = "Document can not be recovered: out of date";
        public static final String TOAST_DOC_RULE_CREATED = "Doc rule created";
        public static final String TOAST_DOC_RULE_UPDATED = "Doc rule updated";
        public static final String TOAST_DOC_RULE_DELETED = "Doc rule deleted";
        public static final String TOAST_DOC_RULE_DUPLICATE = "Doc rule already exists";
        public static final String TOAST_CATEGORY_CREATED = "Category created";
        public static final String TOAST_CATEGORY_UPDATED = "Category updated";
        public static final String TOAST_CATEGORY_DELETED = "Document category deleted";
        public static final String TOAST_NEW_CATEGORY_NAME_CONTROL = "Category with this name already exist";
        public static final String TOAST_NEW_CATEGORY_INDEX_CONTROL = "Category with this index already exist";
        public static final String TOAST_CREATE_TD = "Transport declaration created";
        public static final String TOAST_UPDATE_TD = "Transport declaration updated";
        public static final String MODAL_ACCEPT_DELETE = "Are you sure want to delete this item?";
        public static final String MODAL_DUPLICATE_TD = "The transport declaration with fuel number already exists";
        public static final String MODAL_MIXED_DATE = "The dates of the transport declaration are mixed up";
        public static final String INVALID_VALUE = "Value is invalid";
        public static final String MODAL_DELETE_CATEGORY_WITH_DOCS = "The document category with identifier has linked documents.";
        public static final String MODAL_DELETE_CATEGORY_WITH_EMPTY_CHILD = "The document category with identifier has children";
        public static final String TOAST_DELETE_LAST_DOC_RULE = "The document must be assigned at least one rule";

        static String[] POSITION_TEST = {"LS", "RS", "JS1", "JS2", "S1", "S2", "S3", "S4"};
        public static final List<String> POSITION_TEST_LIST = Arrays.asList(POSITION_TEST);

    }

    public static class Dictionary {
        static String[] CREW_TYPE = {"ALL", "FD", "CC"};
        static String[] CREW_CAT = {"cat 1", "cat 2", "cat 3", "cat 4", "cat 5", "cat 6"};
        static String[] CREW_POSITION = {"LS", "RS", "JS", "JS", "S", "S", "S", "S", "RLS", "LRS", "JLS", "JLS", "JRS", "JRS", "RJS", "LJS"};
        static String[] CREW_QUALIFICATION = {"CFI", "CP", "CPrh", "TRE", "FO"};
        static String[] CREW_ROLE = {"PIC", "SP"};
        static String[] CREW_SUB_TASK = {"PICUS", "LE", "LTC"};
        static String[] GENERAL_MEMBER_TYPE = {"Trainer", "Trainee"};
        static String[] ADDITIONAL_MEMBER_TYPE = {"Trainer", "Trainee", "Member"};
        static String[] AIRLINES_CODE = {"GH", "S7", "XT"}; // "GH", "S7", "XT", "ALL"
        static String[] AIRCRAFT_NAME = {"Airbus A320(sharklets)", "Airbus A320neo", "Airbus A321",
                "Airbus A321(sharklets)", "Airbus A321neo", "Boeing 737-800 (winglets) Freighter", "Boeing 737-800 (winglets) pax",
                "Boeing 737-900 (winglets) pax", "Embraer 170"};
        static String[] BOARD_REG_NUMBERS = {"VQ-BYA", "VP-BEM", "RA-73458", "VP-BSR", "VQ-BBO", "VQ-BYM",
                "RA-73442", "RA-73438", "RA-73434", "RA-73425", "RA-73460", "VQ-BCF", "RA-73468", "RA-02871",
                "RA-02859", "RA-02860", "RA-02872", "RA-73427", "VP-BWN", "VQ-BFJ", "VQ-BDI", "VQ-BYD",
                "RA-73429", "VQ-BYJ", "VQ-BFQ", "RA-73445", "VQ-BYS", "VQ-BSD", "RA-73457", "RA-73431",
                "RA-73464", "RA-73461", "RA-02861", "RA-73426", "RA-73416", "RA-73491", "VP-BVI", "VQ-BTO",
                "VQ-BTL", "VQ-BSC", "VQ-BYV", "VQ-BYW", "RA-73453", "RA-73437", "VP-BSH", "VQ-BYT", "VQ-BRA",
                "RA-02869", "VP-BWB", "VQ-BYK", "RA-73444", "VQ-BYB", "VP-BPC", "VQ-BYH", "RA-73463", "VQ-BDW",
                "VQ-BYF", "RA-73449", "VQ-BYC", "RA-73433", "RA-02870", "VP-BPO", "RA-02868", "VQ-BRI",
                "RA-73435", "RA-73428", "RA-73450", "RA-73441", "RA-73454", "VP-BWM", "RA-73440", "RA-02874",
                "RA-02873", "RA-73451", "RA-73459", "RA-73467", "VQ-BCK", "VQ-BDU", "VQ-BYI", "VQ-BDX",
                "VP-BVJ", "RA-73465", "RA-73466", "VP-BTB", "VQ-BYG", "RA-73415", "RA-02866", "RA-73413",
                "RA-73448", "RA-73414", "RA-02745", "RA-02864", "RA-73436", "VP-BTY", "VQ-BCH", "RA-73446",
                "RA-73443", "VQ-BGU", "VQ-BCR", "VP-BWC", "VQ-BQI", "VQ-BYN", "RA-02863", "RA-73462",
                "VQ-BRB", "RA-73432", "RA-73430", "VQ-BYQ", "VQ-BDB", "VQ-BDQ", "VP-BEN", "RA-73452", "VP-BSL",
                "VQ-BSF", "VQ-BGT", "RA-73456", "VQ-BGR", "VQ-BYL", "RA-02867", "RA-73439", "RA-02865",
                "VP-BWT", "VQ-BYR", "VQ-BYE", "VQ-BQK", "VQ-BQH", "RA-02862", "VQ-BWO", "VQ-BDV", "VQ-BQJ",
                "RA-73492", "RA-73490"};
        static String[] COUNTRY_NAME = {"China", "Turkey", "United Arab Emirates", "Belarus", "Tajikistan",
                "Uzbekistan", "Armenia", "Kyrgyzstan", "Thailand", "Turkmenistan", "Russian Federation"};
        static String[] AIRPORTS_CODE = {"GDX", "MRV", "OSS", "PKC", "BKK", "OGZ", "GRV", "DXB", "AER", "TOF",
                "ULV", "UGC", "TLK", "IAR", "KJA", "IKU", "MSQ", "NBC", "NOZ", "PWE", "PEZ", "BTK", "RGK",
                "DWC", "SVX", "KZN", "KGD", "SKD", "TJM", "UUD", "UFA", "LBD", "HTA", "YKS", "GOJ", "KEJ",
                "KUF", "ASF", "FRU", "VOG", "EVN", "SGC", "CEE", "GSV", "KYZ", "MJZ", "MMK", "NJC", "NSK",
                "REN", "PKX", "DYR", "ASB", "BAX", "BQS", "DYU", "IJK", "TAS", "KHV", "UUS", "MCX", "SVO",
                "NER", "NUX", "NOJ", "ABA", "AYT", "IST", "HMA", "FEG", "OMS", "PEE", "IKT", "LED", "OVB",
                "VVO", "DME", "CEK"};
        static String[] CATEGORIES = {"Основные документы", "Документы JL для рейсов МВЛ",
                "Документы по стране прибытия", "Документы по АП прибытия",
                "Памятки по размещению, трансферу и эстафете", "Особенности выполнения полётов",
                "Прочая информация", "Документы по ВС", "Документы по типу ВС", "Сертификаты дезинсекции",
                "Чек-листы, анкеты, бланки", "Документы по центровке",
                "Прочее", "Категория для документов вместо белой страницы"};
        static String[] OWNERS = {"ЛД", "ДНО", "ДЛС", "ВРАЧ", "ТХ", "ДОПП", "СБП"};
        static String[] ROUTE_CAT = {"NO CATEGORY", "ES_LF DUTY", "SPLITDUTY", "FLT INT-DOM WITH TS (DOM)",
                "FLT INT-INT WITH TS (DOM)", "CIS", "SCHENGEN VISA IS REQUIRED", "PAX&CM TO SUPNUM LIST",
                "3 LEGS OR MORE", "MALE/FEMALE FOR HOTAC", "DOM", "INT", "HOTAC INT", "HOTAC DOM",
                "HOTAC DOUBLE ROOMS", "FOR TRAININGS", "NOT FOR CAT 107", "NOT FOR CAT 166", "LUNCH BREAK",
                "AIRPORT CAT B", "CC MALE ON FLIGHT", "COVID VACСINE CERTIFICATE", "COVID SPUTNIK V CERTIFICATE",
                "73H/32A CC CREW", "73H/32A CC CREW INT"};


        public static final List<String> CREW_MEMBER_TYPE = Arrays.asList(CREW_TYPE);
        public static final List<String> CREW_CATEGORY = Arrays.asList(CREW_CAT);
        public static final List<String> POSITION = Arrays.asList(CREW_POSITION);
        public static final List<String> QUALIFICATION = Arrays.asList(CREW_QUALIFICATION);
        public static final List<String> ROLE = Arrays.asList(CREW_ROLE);
        public static final List<String> SUB_TASK = Arrays.asList(CREW_SUB_TASK);
        public static final List<String> TYPE_GENERAL = Arrays.asList(GENERAL_MEMBER_TYPE);
        public static final List<String> TYPE_ADDITIONAL = Arrays.asList(ADDITIONAL_MEMBER_TYPE);
        public static final List<String> AIRLINES = Arrays.asList(AIRLINES_CODE);
        public static final List<String> AIRCRAFTS = Arrays.asList(AIRCRAFT_NAME);
        public static final List<String> BOARDS = Arrays.asList(BOARD_REG_NUMBERS);
        public static final List<String> COUNTRIES = Arrays.asList(COUNTRY_NAME);
        public static final List<String> AIRPORTS = Arrays.asList(AIRPORTS_CODE);
        public static final List<String> DOC_CATEGORIES = Arrays.asList(CATEGORIES);
        public static final List<String> DOC_OWNERS = Arrays.asList(OWNERS);
        public static final List<String> ROUTE_CATEGORIES = Arrays.asList(ROUTE_CAT);
    }
}


