# Trabalho Final

## Informações

- *Tempo limite:* 3 horas
- A partir do repositório do curso, crie sua branch seguindo o padrão: `final-[nome-sobrenome]`
- Faça commits ao longo do desenvolvimento — **não deixe tudo para um único commit no final**

---

## Objetivo

Desenvolver um sistema de linha de comando para controle do acervo e empréstimos de uma biblioteca que gerencia **dois tipos de itens diferentes** e mantém todos os dados persistidos em arquivo.

---

## Implementações Base

### Estrutura do acervo

A biblioteca possui dois tipos de itens:

- **Livro:** título, autor, ISBN, ano de publicação
- **Revista:** título, editora, número da edição, ano da edição

Ambos compartilham comportamentos em comum: podem ser *emprestados*, *devolvidos* e *consultados*.

Crie uma *classe base* para representar um item da biblioteca e *duas subclasses*, uma para cada tipo.
Crie também uma *interface* para representar a capacidade de ser emprestado, *implementada pela classe base*.
O sistema deve gerenciar livros e revistas em uma *única coleção polimórfica*.

---

### Cadastro e listagem
- Cadastrar *livros* e *revistas* com seus dados específicos
- Listar todos os itens do acervo com *tipo*, *título* e *status* (disponível ou emprestado)
- Campos inválidos devem exibir *mensagem de erro sem encerrar o programa*

---

### Controle de empréstimos
- Emprestar um item pelo título — *impedir o empréstimo* caso já esteja emprestado
- Registrar o *nome de quem retirou* no momento do empréstimo
- Devolver um item pelo título
- Uma mesma pessoa *não pode ter mais de 2 itens emprestados simultaneamente*
- Erros de operação (*item não encontrado*, *item indisponível*, *limite atingido*) devem ser tratados com *exceções próprias*

---

### Remoção e persistência
- Remover um item do acervo pelo título
- Os dados de *todos os itens* devem ser *mantidos entre execuções*, incluindo tipo, status de empréstimo e nome do responsável

---

## Implementações Extras *(do mais simples ao mais complexo)*

### Resumo do acervo
- Exibir total de itens, quantos estão disponíveis e emprestados, e quantos são livros vs revistas

---

### Filtro por tipo
- Listar apenas os *livros* ou apenas as *revistas* do acervo

---

### Busca por atributo específico
- Buscar livros pelo *autor*
- Buscar revistas pela *editora*

---

### Histórico de empréstimos
- Registrar e exibir *quantas vezes cada item foi emprestado* desde o cadastro
- A contagem deve ser *persistida no arquivo*

---

## Critérios de Avaliação

### Implementações Base
- Cumprimento correto de todos os requisitos obrigatórios

---

### Organização do Código
- Código limpo, indentado e bem estruturado
- Separação em classes com responsabilidades definidas — *não coloque tudo no `main`*
- Uso correto de *herança*, *interface*, *polimorfismo* e *exceções checked*

---

### Lógica e Funcionamento
- Livros e revistas gerenciados na *mesma coleção* e persistidos no *mesmo arquivo*
- Empréstimos, devoluções, limite por pessoa e persistência funcionando corretamente
- Exceções lançadas e tratadas corretamente
- Nenhum crash por entrada inválida

---

### Boas Práticas de Git
- *Commits com mensagens claras e descritivas*
- Histórico progressivo refletindo a evolução do desenvolvimento (ex: interface → classe base → subclasses → gerenciador → menu)
- Branch nomeada corretamente: `final-[nome-sobrenome]`

---

### Implementações Extras
- Recursos adicionais implementados além do mínimo exigido

---

## Entrega

1. Certifique-se de que todo o código está na branch `final-[nome-sobrenome]`
2. Faça o **push** da sua branch ao fim do desenvolvimento
3. Entregue dentro do prazo de **3 horas**
