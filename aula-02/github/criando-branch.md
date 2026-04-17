# Criando uma Branch no Git

### 1. Busque as atualizações do repositório remoto

```bash
git fetch
```

### 2. Atualize sua branch local

```bash
git pull
```

### 3. Crie e mude para a nova branch

```bash
git checkout -b nome-da-branch
```

### 4. Faça suas alterações e commit

```bash
git add .
git commit -m "feat: descrição do que foi feito"
```

### 5. Envie a branch para o remoto

```bash
git push --set-upstream origin nome-da-branch
```
