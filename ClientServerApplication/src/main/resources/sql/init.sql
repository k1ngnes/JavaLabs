--Создать таблицу
CREATE TABLE IF NOT EXISTS employees (
    login VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL
    );
-- добавить админ юзера (с паролем 1234)
INSERT INTO employees (login, password, full_name)
VALUES ('admin', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'admin')
    ON CONFLICT (login) DO NOTHING;

-- Добавить таблицу с пректом
CREATE TABLE IF NOT EXISTS projects (
    name VARCHAR(255) PRIMARY KEY,
    manager VARCHAR(255) REFERENCES employees(login) ON DELETE CASCADE
    );

-- добавить таблицу с задачами
CREATE TABLE IF NOT EXISTS tasks (
                                     task_id SERIAL PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
    description TEXT,
    project_name VARCHAR(255) REFERENCES projects(name) ON DELETE CASCADE,
    assignee_login VARCHAR(255) REFERENCES employees(login) ON DELETE SET NULL
    );

-- таблица для трудоотчетов
CREATE TABLE IF NOT EXISTS worklogs (
                                        id SERIAL PRIMARY KEY,
                                        comment TEXT NOT NULL,
                                        date DATE NOT NULL,
                                        timespent INT NOT NULL,
                                        author VARCHAR(255) REFERENCES employees(login) ON DELETE SET NULL,
    task INT REFERENCES tasks(task_id) ON DELETE CASCADE
    );

-- добавить таблицу для хранения сессии
CREATE TABLE sessions (
                          login VARCHAR(255) PRIMARY KEY REFERENCES employees(login) ON DELETE CASCADE,
                          date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                          session VARCHAR(255) NOT NULL
);




