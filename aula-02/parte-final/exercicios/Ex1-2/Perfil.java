class Perfil {

    void exibirNome() {
        IO.println("Nome: João Silva");
    }

    void exibirCurso() {
        IO.println("Curso: Análise e Desenvolvimento de Sistemas");
    }

    void exibirAno() {
        int ano = java.time.LocalDate.now().getYear();
        IO.println("Ano: " + ano);
    }
}
