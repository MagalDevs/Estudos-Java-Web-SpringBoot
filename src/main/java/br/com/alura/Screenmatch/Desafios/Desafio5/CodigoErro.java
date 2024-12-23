package br.com.alura.Screenmatch.Desafios.Desafio5;

public enum CodigoErro {
    NOT_FOUND(404, "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource. Links that lead to a 404 page are often called broken or dead links and can be subject to link rot."),
    BAD_REQUEST(400, "The HTTP 400 Bad Request response status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error (for example, malformed request syntax, invalid request message framing, or deceptive request routing)."),
    INTERNAL_SERVER_ERROR(500, "The HTTP 500 Internal Server Error server error response code indicates that the server encountered an unexpected condition that prevented it from fulfilling the request.");

    private int codigo;
    private String descricao;

    CodigoErro(int i, String s) {
        this.codigo = i;
        this.descricao = s;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
