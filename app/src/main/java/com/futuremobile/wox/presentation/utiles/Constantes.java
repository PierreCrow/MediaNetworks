package com.futuremobile.wox.presentation.utiles;


public class Constantes {


    public class URLS {
        public static final String URL_BASE = "http://50.116.16.150/web-media-networks/public/api/";

        public static final String SYNC = "v1/bajar_sincronizacion";
        public static final String INI_ACTION = "";
        public static final String FIN_ACTION = "";
        public static final String LOGIN = "auth/login";

    }

    public static class ESTADO_WORK_ORDER {
        public static final int REGISTRO_PARCIAL = 1;
        public static final int REGISTRADO = 2;
        public static final int PENDIENTE_APROBACION_TECNICA = 3;
        public static final int APROBADO_TECNICAMENTE = 4;
        public static final int PLANEADO = 5;
        public static final int ACTIVADO = 6;
        public static final int FINALIZADO = 7;
        public static final int OBSERVADO_POR_GESTOR = 10;
        public static final int OBSERVADO_TECNICAENTE = 11;
        public static final int OBSERVADO_POR_MESA = 12;
    }

    public static class CONDICION_LINEA_TIEMPO {
        public static final int ANTES = 1;
        public static final int DURANTE = 2;
        public static final int DESPUES = 3;
        public static final int ROLLBACK = 4;
    }

    public static class TIPO_TRABAJO {
        public static final int COMERCIAL = 1;
        public static final int CORRECTIVO = 2;
        public static final int DISPOSITIVOS = 3;
        public static final int HERRAMIENTAS = 4;
        public static final int HOSTING = 5;
        public static final int INFRAESTRUCTURA_TI = 6;
        public static final int NUEVOS_DESPLIEGUES_HW = 7;
        public static final int PREVENTIVO = 8;
        public static final int PROGRAMADOR = 9;
        public static final int PROVISION = 10;
        public static final int RELEASE_SW = 11;
        public static final int SEGURIDAD = 12;
    }



    public static class APP_ {
        public static final String DATABASE_NAME = "Wox_db";
        public static String APPNAME = "Work Order eXecutor";
    }


    public static class TABLES {
        public static final String TABLA_CATEGORIA = "Category";
        public static final String TABLA_PROVEEDOR = "Proveedores";
        public static final String TABLA_ENTRADASTOCK = "Expense";
    }

    public static class RESULT_CODE {
        public static final int TAGGEAR_CODE = 6;
        public static final int REQUEST_TAGGEAR_CODE = 5;
        public static final int BARCODER_CODE = 0;
        public static final int REQUEST_CODE_QR = 9001;
        public static final int REQUEST_CODE_LOCATION = 9002;
        public static final int REQUEST_CODE_OF_MODAL = 9003;
        public static final int GROUP_BOX_CODE = 1000;
        public static final int COME_BACK_FROM_SETTINGS = 2000;
        public static final int PERMISIONS_REQUEST_CODE = 1024;
    }


    public class RESPONSES_OK_DB {
        public static final String LOGIN_RESPONSE_OK_DB = "Inicio de Sesión Correcto!";
        public static final String LOGOUT_RESPONSE_OK_DB = "LOGOUT_RESPONSE_OK_DB";
        public static final String REGISTAR_EMPRESA_RESPONSE_OK_DB = "REGISTAR_EMPRESA_RESPONSE_OK_DB";
        public static final String EDITAR_EMPRESA_RESPONSE_OK_DB = "EDITAR_EMPRESA_RESPONSE_OK_DB";
        public static final String INACTIVAR_EMPRESA_RESPONSE_OK_DB = "INACTIVAR_EMPRESA_RESPONSE_OK_DB";
        public static final String REGISTAR_ROL_RESPONSE_OK_DB = "REGISTAR_ROL_RESPONSE_OK_DB";
        public static final String EDITAR_EMPRESA_ROL_OK_DB = "EDITAR_EMPRESA_ROL_OK_DB";
        public static final String INACTIVAR_ROL_RESPONSE_OK_DB = "INACTIVAR_ROL_RESPONSE_OK_DB";
        public static final String REGISTAR_USUARIO_RESPONSE_OK_DB = "REGISTAR_USUARIO_RESPONSE_OK_DB";
        public static final String EDITAR_USUARIO_RESPONSE_OK_DB = "EDITAR_USUARIO_RESPONSE_OK_DB";
        public static final String INACTIVAR_USUARIO_RESPONSE_OK_DB = "INACTIVAR_USUARIO_RESPONSE_OK_DB";
        public static final String REGISTAR_ALMACEN_RESPONSE_OK_DB = "REGISTAR_ALMACEN_RESPONSE_OK_DB";
        public static final String EDITAR_ALMACEN_RESPONSE_OK_DB = "EDITAR_ALMACEN_RESPONSE_OK_DB";
        //preguntar x el de abajo xq alamcen esta con m
        public static final String INACTIVAR_ALMACEN_RESPONSE_OK_DB = "INACTIVAR_ALMACEN_RESPONSE_OK_DB";
        public static final String REGISTAR_CATEGORIA_RESPONSE_OK_DB = "REGISTAR_CATEGORIA_RESPONSE_OK_DB";
        public static final String EDITAR_CATEGORIA_RESPONSE_OK_DB = "EDITAR_CATEGORIA_RESPONSE_OK_DB";
        public static final String INACTIVAR_CATEGORIA_RESPONSE_OK_DB = "INACTIVAR_CATEGORIA_RESPONSE_OK_DB";
        public static final String REGISTAR_PRODUCTO_RESPONSE_OK_DB = "REGISTAR_PRODUCTO_RESPONSE_OK_DB";
        public static final String EDITAR_PRODUCTO_RESPONSE_OK_DB = "EDITAR_PRODUCTO_RESPONSE_OK_DB";
        public static final String INACTIVAR_PRODUCTO_RESPONSE_OK_DB = "INACTIVAR_PRODUCTO_RESPONSE_OK_DB";
        public static final String SIZE_0_DB = "Size 0 DB";
        public static final String CANT_GET_LIST_DB = "CANT GET LIST DB";

    }


    public class PREFERENCES {
        public static final String PREFERENCE_CURRENT_USER = "PREFERENCE_CURRENT_USER";
    }


    public class PREFERENCES_KEYS {
        public static final String CURRENT_USER_ID_EMPRESA = "CURRENT_USER_ID_EMPRESA";
        public static final String CURRENT_USER_ID_USUARIO = "CURRENT_USER_ID_USUARIO";
        public static final String CURRENT_USER_TOKEN = "CURRENT_USER_TOKEN";
        public static final String CURRENT_USER_LOGUEADO = "CURRENT_USER_LOGUEADO";
        public static final String CURRENT_USER_EMAIL = "CURRENT_USER_EMAIL";
        public static final String CURRENT_USER_STATE = "CURRENT_USER_STATE";
        public static final String CURRENT_USER_NAME = "CURRENT_USER_NAME";
        public static final String CURRENT_USER_ROL = "CURRENT_USER_ROL";
        public static final String CURRENT_USER_WAREHOUSE_SELECTED = "CURRENT_USER_WAREHOUSE_SELECTED";
        public static final String CURRENT_USER_ID_WAREHOUSE = "CURRENT_USER_ID_WAREHOUSE";

    }


    public class FRAGMENTS_TAGS {
        public static final String HOME = "HOME_TAG";
    }


    public class IMAGE_EXTENSION {
        public static final String DOT_JPG = ".jpg";
        public static final String DASH_MIN = "-min";
    }


    public static class TYPE_DIALOG {
        public static final int TYPE_ERROR = 0;
        public static final int TYPE_LOG_OUT = 1;
        public static final int TYPE_OVERALL = 2;
        public static final int TYPE_WARNING = 3;
        public static final int TYPE_SUCCESS = 4;
        public static final int TYPE_SYNC = 5;
    }


    public static class STORE {
        public static final int CLOUD = 0;
        public static final int DB = 1;
    }

    public static class APP_VERSION {
        public static final String MAJOR = "1";
        public static final String EQUAL = "0";
        public static final String MINOR = "-1";
    }

    public static class OBSERVATIONS_QUANTITY_LETTERS {
        public static final int MAX_LETTERS = 200;
        public static final int ONE_HUNDRED = 100;
        public static final int FIFTY = 50;
        public static final int TWENTY = 20;
        public static final int MIN_LETTERS = 0;
    }

    public class MINUTES_SERVICE_RUN {
        public static final int MINUTES_NETWORK_VALIDATION = 1;
        public static final int SECONDS_NETWORK_VALIDATION = 30;
        public static final int MINUTES_REFRESH_TOKEN = 45;
    }


    public class RESPONSE_CODES {
        public static final int SUCCESS = 1;
        public static final int SERVER_CONNECTION_SUCCESS = 200;

        public static final String USER_CODE_NOT_REGISTERED = "ESRE0001";
    }

    public class RESPONSE_MESSAGES {
        public static final String ERROR = "Error al conectarse al servidor";
    }


}
