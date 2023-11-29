# README
## XML_JSONConverter
XML_JSONConverter - сервис для преобразования файлов из формата XML в JSON и наоборот.

### Особенности:
- Поддержка форматов XML и JSON.
- Возможность запуска из командной строки.
- Обработка файлов определенной структуры.

### Начало работы
- **1. Клонирование репозитория**
  ```
  git clone https://github.com/Nightarc/XML_JSONConverter.git
  ```
  **ИЛИ**
- **1. Скачивание последней версии из [Releases](https://github.com/Nightarc/XML_JSONConverter/releases)**
- **2. Запуск программы**
    Для запуска программы используется либо IDE либо командная строка.
    Синтаксис команды запуска из командной строки:
  
  ```
  XML_JSONConverter.jar <input-file-path> <output-file-path> 
  ```

  
### Структура:
- `src`: Исходный код проекта.
  - `main`: Основной код приложения.
    - `java`: Исходные файлы Java.       
  - `test`: Модульные тесты для приложения.
    - `resources`: Ресурсы программы (например, примеры XML и JSON файлов).
            
### Входные и выходные файлы
- Сервис работает с файлами формата XML и JSON определённой структуры(см. файлы в test/resources).
> [!CAUTION]
> При преобразовании файлов из формата XML в JSON, пустые численные поля в файле читаются как целочисленный ноль, и записываются также. При обратном преобразовании нули сохраняются.

### Пример использования 
Конвертация XML в JSON:
```
-java XML_JSONConverter.jar XMLExample.xml JSONExample.json
```
Конвертация JSON в XML:
```
-java XML_JSONConverter.jar JSONExample.json XMLExample.xml
```
  
