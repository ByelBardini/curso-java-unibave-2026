# Clonando um Repositório

### 1. Copie a URL do repositório

No GitHub, clique em **Code** → **HTTPS** e copie a URL:

```
https://github.com/usuario/nome-do-repositorio.git
```

### 2. Clone o repositório

```bash
git clone https://github.com/usuario/nome-do-repositorio.git
```

Isso cria uma pasta com o nome do repositório no diretório atual.

### 3. Acesse a pasta criada

```bash
cd nome-do-repositorio
```

### 4. Veja as branches disponíveis

```bash
git branch -a
```

### 5. Mude para a branch desejada

```bash
git checkout nome-da-branch
```

---

> Após clonar, siga o tutorial de [criando-branch.md](criando-branch.md) para criar sua própria branch e começar a trabalhar.
