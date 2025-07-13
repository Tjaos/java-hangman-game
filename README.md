# 🎯 Jogo da Forca - Desafio DIO: Programação Orientada a Objetos em Java

Este projeto é a implementação de um jogo da forca em ambiente console, desenvolvido em **Java (JDK 21)**. Ele simula a experiência de um jogo tradicional da forca, com uma interface em texto que permite ao usuário interagir por meio de menus, digitando letras para adivinhar a palavra oculta.

> Projeto realizado como parte da formação Java na **DIO (Digital Innovation One)**, focado no uso prático de **Programação Orientada a Objetos (POO)**.

---

## 🚀 Funcionalidades

- Escolha de palavra oculta via argumentos de execução
- Interação por menu com entrada de dados via console
- Montagem gráfica simplificada da forca
- Lógica completa de acertos e erros
- Tratamento de exceções personalizadas
- Exibição do estado atual do jogo a qualquer momento

---

## 🧠 Conceitos Aplicados

Durante o desenvolvimento deste projeto, foram colocados em prática os seguintes conceitos:

- ✅ **POO (Programação Orientada a Objetos)**: uso de classes, objetos, métodos e encapsulamento
- ✅ **Exceções personalizadas** (`GameIsFinishedException`, `LetterAlreadyInputedException`)
- ✅ **Manipulação de listas e strings**
- ✅ **Uso de `enum` para controle de status do jogo** (`PENDING`, `WIN`, `LOSE`)
- ✅ **Separação de responsabilidades em múltiplas classes**
- ✅ **Organização de código em pacotes**
- ✅ **Entrada e saída via console com `Scanner`**

---

## 🛠️ Tecnologias e Ferramentas

- **Java 21**
- **IDE:** IntelliJ IDEA / Eclipse / VS Code (à sua escolha)
- **Git e GitHub**
- **Console / Terminal**
- **Markdown** para documentação

---

## 📂 Estrutura do Projeto

```bash
├── src/
│   ├── br/com/dio/hangman/
│   │   ├── Main.java
│   │
│   ├── br/com/dio/hangman/model/
│   │   ├── HangmanGame.java
│   │   ├── HangmanChar.java
│   │   ├── HangmanGamesStatus.java
│   │
│   ├── br/com/dio/hangman/exception/
│       ├── GameIsFinishedException.java
│       ├── LetterAlreadyInputedException.java
│
├── README.md
```
## 📸 Imagens

### 1️⃣ Definindo a palavra secreta como argumentos
<img src="https://github.com/user-attachments/assets/f5d122a7-b62f-4f39-9f2e-c9a5d2a6605e" width="700" alt="Definindo a palavra secreta como argumentos de execução" />

---

### 2️⃣ Rodando o código
<img src="https://github.com/user-attachments/assets/6d6a8463-a341-4467-b823-163bdfe835bf" width="600" alt="Executando o jogo no console" />

---

### 3️⃣ Selecionando a opção de status do jogo
<img src="https://github.com/user-attachments/assets/24797c34-e152-46e5-94c9-35805602fd43" width="500" alt="Selecionando opção de status do jogo" />

---

### 4️⃣ Digitando uma letra correta
<img src="https://github.com/user-attachments/assets/0782c072-cee8-4553-a2ca-a393f064468d" width="500" alt="Letra correta sendo digitada e revelada" />

---

### 5️⃣ Digitando uma letra incorreta
<img src="https://github.com/user-attachments/assets/bad13e22-51d4-4e4e-8d3b-5794ab7539c3" width="500" alt="Letra incorreta sendo digitada, boneco atualizado" />







