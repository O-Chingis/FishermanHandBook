# Справочник рыбака

**Мобильное приложение для рыболовов**, предоставляющее базу знаний о рыбах, снастях, наживках и возможность ведения личных заметок.

---

## 📋 О проекте

**Справочник рыбака** создан для упрощения рыбалки и улучшения пользовательского опыта. Оно помогает:

- Узнавать о видах рыб, снастях и наживках.
- Вести заметки о рыболовных достижениях.
- Читaть советы и истории от других рыбаков.

### Основные функции:
- **База знаний** о рыбе, снастях и наживках.
- **Личные заметки** с сохранением в локальном хранилище.
- **Интуитивно понятный интерфейс**, соответствующий принципам Material Design.

---

## 🔧 Технологии

Проект разработан с использованием:

- **Kotlin** — современный язык для Android.
- **Android Studio** — интегрированная среда разработки.
- **SharedPreferences** — для локального хранения данных.
- **XML** — для описания интерфейсов.

---

## 📁 Архитектура

Приложение построено на многослойной архитектуре:

1. **Презентационный слой (UI):** Отвечает за взаимодействие с пользователем.
2. **Бизнес-логика:** Управляет функционалом приложения, использует MVVM.
3. **Слой данных:** Хранит информацию о рыбе и снастях (XML), а также заметки пользователей (SharedPreferences).

---

## 📱 Установка и использование

1. Разверните приложение, собрав в .apk и перенесите в мобильное устройство
2. Установите его на свое Android-устройство.
3. Изучите рыболовные материалы или создайте свои заметки.

### Навигация:

- **Главный экран:** Доступ к разделам о рыбе, снастях, наживках и заметках.
- **Создание заметок:** Нажмите на «+», заполните данные и сохраните.

---

## 🧪 Тестирование

Приложение протестировано с использованием **JUnit** и **AndroidX Testing**:

- Проверка корректной загрузки заметок.
- Тестирование навигации между экранами.
- Обеспечение возврата к главному экрану по нажатию "Назад".

---

## 📈 План развития

- Расширение базы данных о рыбе и снастях.
- Внедрение функции синхронизации данных через облако.
- Улучшение пользовательского интерфейса.

---

## 🖇️ Ссылки

- [Документация Android Developers](https://developer.android.com/develop)
- [Jetpack Compose](https://developer.android.com/develop/ui/compose/documentation?hl=ru)

---

## ✨ Автор

- **Студент:** Ч.С. Очиров, КИ21-17/1Б.