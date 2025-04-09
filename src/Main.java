public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     */
    public static String getScore(int player1Score, int player2Score) {

        if (player1Score == player2Score) {
            return puntuacionEmpate(player1Score);
        }
        else if (player1Score >=4 || player2Score >=4) {
            return jugadorConVentajaOGanador(player1Score, player2Score);
        }
        else {
            return puntuacionSinEmpate(player1Score, player2Score);
        }
    }

    private static String puntuacionEmpate(int player1Score) {

        return switch (player1Score) {

            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";

        };
    }

    private static String puntuacionSinEmpate(int player1Score, int player2Score) {

        String puntuacionDelJuego = posiblesPuntuaciones(player1Score);
            puntuacionDelJuego += "-" +  posiblesPuntuaciones(player2Score);

        return puntuacionDelJuego;
    }

    private static String posiblesPuntuaciones(int puntuacionJugador) {

        return switch (puntuacionJugador) {

            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "ERROR";

        };
    }

    private static String jugadorConVentajaOGanador(int player1Score, int player2Score) {

        int diferencia = player1Score - player2Score;

        if (diferencia == 1) {
            return "Advantage player1";}
        else if (diferencia == -1){
            return "Advantage player2";}
        else if (diferencia >= 2){
            return  "Win for player1";}
        else{
            return "Win for player2";}
        //aqui pense en hacer un switch pero por culpa del >=2 seria complicado
    }
}