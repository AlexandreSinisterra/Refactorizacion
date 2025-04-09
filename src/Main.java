public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     */
    public static String getScore(int player1Score, int player2Score) {
        String score = "";

        if (player1Score == player2Score) {
            score = puntuacionEmpate(player1Score);
        }
        else if (player1Score >=4 || player2Score >=4)
        {
            score = jugadorConVentajaOGanador(player1Score, player2Score);
        }
        else
        {
            score = puntuacionSinEmpate(player1Score, player2Score, score);
        }
    return score;
    }

    private static String puntuacionSinEmpate(int player1Score, int player2Score, String score) {
        int puntuacionJugador;
        for (int i = 1; i<3; i++)
        {

            if (i==1){
                puntuacionJugador = player1Score;}
            else {
                score +="-"; puntuacionJugador = player2Score;}

            switch(puntuacionJugador)
            {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
                default:
                    score += "ERROR";
                    break;
            }

        }
        return score;
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
}