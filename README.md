# Exercício de Revisão

## Informações

- *Tempo limite:* 2 horas
- A partir do repositório do curso, crie sua branch seguindo o padrão: `revisao-[nome-sobrenome]`
- Faça commits ao longo do desenvolvimento — **não deixe tudo para um único commit no final**

---

## Contexto

Uma escola precisa de um sistema de linha de comando para gerenciar os alunos de uma turma, com cadastro, consulta e persistência de dados entre execuções.

---

## Implementações Base

### Cadastro e listagem
- Cadastrar alunos com *nome*, *matrícula* e *duas notas*
- Listar todos os alunos com *média* e *situação* (aprovado se média ≥ 7,0)
- Campos inválidos (nome em branco, notas fora do intervalo 0–10) devem exibir *mensagem de erro sem encerrar o programa*

---

### Busca e remoção
- Buscar um aluno pelo *nome*
- Remover um aluno pelo *nome*

---

### Persistência
- Os dados devem ser *mantidos entre execuções* — ao reabrir o programa, os alunos cadastrados continuam lá

---

## Implementações Extras *(do mais simples ao mais complexo)*

### Estatísticas da turma
- Exibir *total de alunos*, quantidade de *aprovados* e *reprovados*, e *maior e menor média*

---

### Matrícula única
- Impedir o cadastro de *duas matrículas iguais*

---

### Listagem ordenada
- Listar alunos *ordenados por média*, do maior para o menor

---

## Critérios de Avaliação

### Implementações Base
- Cumprimento correto de todos os requisitos obrigatórios

---

### Organização do Código
- Código limpo, indentado e bem estruturado
- Separação em classes com responsabilidades definidas — *não coloque tudo no `main`*
- Uso correto de *herança* e *encapsulamento*

---

### Lógica e Funcionamento
- Cadastro, busca, remoção e persistência funcionando conforme esperado
- Nenhum crash por entrada inválida

---

### Boas Práticas de Git
- *Commits com mensagens claras e descritivas*
- Histórico progressivo — cada commit representa uma etapa concluída
- Branch nomeada corretamente: `revisao-[nome-sobrenome]`

---

### Implementações Extras
- Recursos adicionais implementados além do mínimo exigido

---

## Entrega

1. Certifique-se de que todo o código está na branch `revisao-[nome-sobrenome]`
2. Faça o **push** da sua branch ao fim do desenvolvimento
3. Entregue dentro do prazo de **2 horas**