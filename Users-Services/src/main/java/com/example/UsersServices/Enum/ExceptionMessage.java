package com.example.UsersServices.Enum;

public enum ExceptionMessage {
    USER_NOT_FOUND( "utilisateur introuvable"),
    USER_NOT_AUTHORIZED("Non autorisé"),
    INTERNAL_SERVER_ERROR("Erreur serveur"),
    EMAIL_ALREADY_EXIST("Adresse mail déjà utilisée"),
    EMAIL_IS_INVALID("Adresse mail invalide ."),
    FIRSTNAME_IS_REQUIRED("Prénom  invalide . Il doit contenir seulement des caractères."),
    LASTNAME_IS_REQUIRED("Nom  invalide, Il doit contenir seulement des caractères."),
    PHONE_NUMBER_NOT_VALID("Numero de telephone non valide"),
    PASSWORD_MATCH_ERROR("Le mot de passe entré ne correspond pas au mot de passe de confirmation."),
    PASSWORD_LENGTH_ERROR("Le mot de passe doit contient au moins 8 caractères."),
    PHONE_IS_NOT_VALID("PHONE_IS_NOT_VALID"),
    USER_INPUT_NOT_VALID("Utilisateur Input Not Valid!");
     private final String msg;
    ExceptionMessage(String msg) {this.msg = msg;}
    public String getMessage() {return this.msg;}
}
