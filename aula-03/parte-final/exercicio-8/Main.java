void main() {
    Aluno a = new Aluno();
    a.setNome("Ana");
    a.setNota1(8.5);
    a.setNota2(7.0);

    IO.println("Aluno: " + a.getNome());
    IO.println("Nota 1: " + a.getNota1());
    IO.println("Nota 2: " + a.getNota2());
    IO.println("Média: " + a.calcularMedia());

    IO.println("\n=== Testando notas inválidas ===");
    a.setNota1(-1);  // bloqueado
    a.setNota2(11);  // bloqueado
    IO.println("Notas permanecem: " + a.getNota1() + " e " + a.getNota2());
}
