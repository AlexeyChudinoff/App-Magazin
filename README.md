# 🛍️ App-Magazin - Java OOP Интернет-магазин

[![Java](https://img.shields.io/badge/Java-17+-blue?logo=java)](https://java.com)  
[![OOP](https://img.shields.io/badge/OOP-Principles-green)](https://en.wikipedia.org/wiki/Object-oriented_programming)  
[![GitHub](https://img.shields.io/badge/GitHub-Repository-lightgrey?logo=github)](https://github.com/AlexeyChudinoff/App-Magazin)

**Полнофункциональное консольное приложение интернет-магазина**,  
демонстрирующее принципы объектно-ориентированного программирования на Java с современной архитектурой.

---

## 🎯 Особенности проекта

### 🏗️ Архитектурные преимущества
- **Чистая архитектура** с разделением ответственности  
- **Интерфейсы и абстракции** для гибкости системы  
- **Наследование и полиморфизм** для расширяемости  
- **Инкапсуляция** данных и бизнес-логики  

### ⚡ Технический стек
- **Java 17+** — основной язык разработки  
- **Custom Logging System** — собственная система логирования  
- **JUnit-style Testing** — полное тестовое покрытие  
- **Git Best Practices** — правильная работа с версиями  

---

## 📦 Основные функциональные модули

### 🛒 Product Management System  
Гибкая система управления продуктами с поддержкой разных типов товаров:

```
// Создание продуктов разных типов
Product simple = new SimpleProduct("Телефон", 10000);
Product fixed = new FixPriceProduct("Книга");          // Фиксированная цена 500₽
Product discounted = new DiscountedProduct("Ноутбук", 50000, 15); // 15% скидка

// Проверка специальных предложений
if (discounted.isSpecial()) {
logger.info("Специальное предложение: " + discounted.getNameProduct());
}
```

### 🧺 Умная корзина покупок  
Полнофункциональная корзина с группировкой и расчетами:

```
ProductBasket basket = new ProductBasket();

// Добавление товаров по категориям
basket.addProduct("Электроника", new SimpleProduct("iPhone 15", 89990));
basket.addProduct("Электроника", new DiscountedProduct("MacBook Air", 99990, 10));
basket.addProduct("Книги", new FixPriceProduct("Clean Code"));

// Операции с корзиной
basket.printBasketCost();    // Общая стоимость: 184491₽
basket.specialProduct();     // Специальные предложения
basket.dellProductByName("iPhone 15"); // Удаление товара
```

### 🔍 Поисковый движок  
Мощная система поиска по товарам и статьям:

```
SearchEngine searchEngine = new SearchEngine();

// Индексация корзины и статей
searchEngine.addBasketInSearchList(basket);
searchEngine.addArticle(new Article("Обзор техники", "Новинки электроники 2024"));

// Разные типы поиска
searchEngine.searchExactMatch("MacBook Air");     // Точный поиск
searchEngine.searchContains("техник");            // Поиск по подстроке
searchEngine.printAllStringRepresentations();     // Вся indexed data
```

### 📝 Контент-система  
Интеграция статей с товарами для расширенного пользовательского опыта:

```
// Создание образовательного контента
Article javaArticle = new Article(
"Java Programming",
"Основы ООП в Java: инкапсуляция, наследование, полиморфизм"
);

Article designPatterns = new Article(
"Паттерны проектирования",
"Factory Method, Strategy и другие паттерны"
);

// Добавление в поисковый индекс
searchEngine.addArticle(javaArticle);
searchEngine.addArticle(designPatterns);
```

### 🎨 Система логирования  
Кастомная система логирования с цветовым выводом:

```
// Разные уровни логирования
logger.debug("Создан новый продукт: " + product.getName());
logger.info("Пользователь добавил товар в корзину");
logger.warn("Попытка добавить товар с отрицательной ценой");
logger.error("Ошибка валидации данных");

// Автоматическое форматирование
// [14:30:25.123] [INFO] - Пользователь добавил товар в корзину
```

### 🧪 Тестовая инфраструктура  
Полное тестовое покрытие всех модулей:

```
// Пример unit-теста
public void testProductCreation() {
Product product = new SimpleProduct("Test", 100);
assertEquals("Test", product.getNameProduct());
assertEquals(100, product.getCostProduct());
}

// Интеграционные тесты
public void testBasketOperations() {
ProductBasket basket = new ProductBasket();
basket.addProduct("Test", new SimpleProduct("Item", 500));
assertEquals(1, basket.getTotalProductsCount());
}
```

Каждый модуль самостоятелен и легко тестируется, демонстрируя принципы SOLID и чистой архитектуры! 🏗️

### Требования  
- JDK 17+  
- Git  

### Установка и запуск  

```
# Клонирование репозитория
git clone https://github.com/AlexeyChudinoff/App-Magazin.git
cd App-Magazin

# Компиляция проекта
javac -d out src/org/skypro/skyshop/**/*.java

# Запуск приложения
java -cp out org.skypro.skyshop.App

# Запуск тестов
java -cp out org.skypro.skyshop.util.TestRunner
```

---

## 🧪 Тестирование

Проект включает полное тестовое покрытие:  
✅ ProductTest — тестирование создания и валидации продуктов  
✅ ProductBasketTest — тестирование операций с корзиной  
✅ SearchEngineTest — тестирование поисковых алгоритмов  
✅ ArticleTest — тестирование системы статей  

Все тесты проходят успешно ✅

---

## 🏆 Демонстрируемые навыки

### 💻 Технические навыки
- Принципы OOP: наследование, полиморфизм, инкапсуляция, абстракция  
- Паттерны проектирования: Factory Method, Strategy, Comparator  
- Работа с коллекциями: HashMap, ArrayList, HashSet, TreeSet  
- Исключения: кастомные исключения и обработка ошибок  
- Логирование: собственная система с цветовым выводом  

### 🔧 Профессиональные практики
- Чистый код с понятной структурой и именованием  
- Модульная архитектура с разделением пакетов  
- Тестирование с полным покрытием функционала  
- Версионный контроль с осмысленными коммитами  
- Документирование кода и проекта  

---

## 📁 Структура проекта

```
src/
├── main/java/org/skypro/skyshop/
│   ├── App.java                 # Главный класс приложения
│   ├── product/                 # Модуль продуктов
│   │   ├── Product.java         # Абстрактный базовый класс
│   │   ├── SimpleProduct.java   # Простой продукт
│   │   ├── FixPriceProduct.java # Продукт с фиксированной ценой
│   │   ├── DiscountedProduct.java # Продукт со скидкой
│   │   ├── Article.java         # Статьи и контент
│   │   └── ProductBasket.java   # Корзина покупок
│   ├── search/                  # Поисковый модуль
│   │   ├── Searchable.java      # Интерфейс поиска
│   │   ├── Printable.java       # Интерфейс вывода
│   │   ├── SearchEngine.java    # Поисковый движок
│   │   └── comparator/
│   │       └── StringLengthComparator.java # Компаратор
│   └── util/                    # Утилиты
│       ├── ConsoleColors.java   # Цветовой вывод
│       ├── SimpleLogger.java    # Система логирования
│       └── TestRunner.java      # Запуск тестов
└── test/java/org/skypro/skyshop/   # Тесты
├── product/
├── search/
└── TestRunner.java
```

---

## 🎨 Пример работы

```
// Создание корзины и продуктов
ProductBasket basket = new ProductBasket();
basket.addProduct("Электроника", new SimpleProduct("iPhone", 100000));
basket.addProduct("Книги", new FixPriceProduct("Java Programming"));

// Расчет стоимости
basket.printBasketCost(); // Общая стоимость: 100500₽

// Поиск товаров
SearchEngine engine = new SearchEngine();
engine.addBasketInSearchList(basket);
engine.searchExactMatch("iPhone");
```

---

## 📈 Возможности расширения

- Веб-интерфейс на Spring Boot  
- База данных для хранения товаров  
- Система аутентификации пользователей  
- Интеграция с платежными системами  
- REST API для мобильных приложений  

---

## 👨‍💻 Автор

Алексей Чудинов

---

## 📄 Лицензия

Этот проект распространяется под лицензией MIT. См. файл LICENSE для подробностей.

---

⭐ Если проект вам понравился, поставьте звезду на GitHub!
```
