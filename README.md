<h1 align="center">📚 Fórum Hub API</h1>

<p align="center">
  <em>API REST inspirada no Fórum da Alura, desenvolvida para gerenciar tópicos, cursos e usuários com autenticação JWT.</em>
</p>

---

## ✨ Funcionalidades

✅ Cadastro de usuários  
✅ Autenticação via **JWT**  
✅ Criação de tópicos (usuário autenticado)  
✅ Listagem de tópicos e detalhes de um tópico  
✅ Atualização de tópicos (apenas autor)  
✅ Exclusão de tópicos (apenas autor)  
✅ Associação de tópicos a cursos  

---

## 🛠 Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| **Java 21** | Linguagem principal |
| **Spring Boot 3.3.3** | Framework backend |
| **Spring Security** | Autenticação e autorização |
| **Spring Data JPA** | Persistência no banco |
| **PostgreSQL** | Banco de dados |
| **Maven** | Gerenciador de dependências |
| **JWT** | Segurança |
| **Insomnia** | Testes de API |

---

## 📜 Regras de Negócio

🔹 Apenas usuários **cadastrados e autenticados** podem criar, editar ou excluir tópicos.  
🔹 Um tópico contém: **Título**, **Mensagem**, **Curso**, **Data de criação** e **Autor**.  
🔹 Apenas o **autor** pode editar ou excluir seu próprio tópico.  
🔹 Data de criação é gerada automaticamente.  

---

## ⚙ Configuração do Projeto

### 1️⃣ Pré-requisitos
- ☕ Java 21 instalado  
- 🛠 Maven instalado  
- 🐘 PostgreSQL em execução  

### 2️⃣ Clonar repositório
```bash
git clone https://github.com/seu-usuario/forum-hub.git
