package com.br.message;

public enum Message {

		USUARIO_EXISTENTE ("Erro, Usuário ja existente!");

		private String message;
	
		Message(String message) {
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}
}
