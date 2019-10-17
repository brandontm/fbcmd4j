package cloud;

public enum PowerState {
    POWERED_ON, POWERED_OFF, SUSPENDED;

    @Override
    public String toString() {
        String title;
        switch (this) {
        case POWERED_ON:
            title = "Encendido";
            break;
        case POWERED_OFF:
            title = "Apagado";
            break;
        case SUSPENDED:
            title = "Suspendido";
            break;
        default:
            title = "Desconocido";
            break;
        }

        return title;
    }
}