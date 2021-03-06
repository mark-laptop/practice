INSERT INTO Citizenship (id, version, name, code)
VALUES (1, 0, 'Российская федерация', 643);

INSERT INTO Document_type (id, version, name, code)
VALUES (1, 0, 'Свидетельство о рождении', 03),
       (2, 0, 'Военный билет', 07),
       (3, 0, 'Временное удостоверение, выданное взамен военного билета', 08),
       (4, 0, 'Паспорт иностранного гражданина', 10),
       (5, 0,
        'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу',
        11),
       (6, 0, 'Вид на жительство в Российской Федерации', 12),
       (7, 0, 'СУдостоверение беженца', 13),
       (8, 0, 'Разрешение на временное проживание в Российской Федерации', 15),
       (9, 0, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации', 18),
       (10, 0, 'Паспорт гражданина Российской Федерации', 21),
       (11, 0, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства', 23),
       (12, 0, 'Удостоверение личности военнослужащего Российской Федерации', 24),
       (13, 0, 'Иные документы', 91);

INSERT INTO Document (id, version, document_type_id, number, date)
VALUES (1, 0, 10, '1234', '0001-01-01'),
       (2, 0, 10, '4321', '0001-01-01'),
       (3, 0, 10, '4444', '0001-01-01'),
       (4, 0, 10, '6666', '0001-01-01'),
       (5, 0, 10, '7564', '0001-01-01');

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 0, 'ООО Рога и копыта', 'Общество  с ограниченной ответственностью "Рога и копыта"', '123456789123',
        '123456789', 'Ленина 47', '89881231212', 1),
       (2, 0, 'ООО Ромашка', 'Общество  с ограниченной ответственностью "Ромашка"', '321987654321', '987654321',
        'Советов 61',
        '89613212121', 1);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active)
VALUES (1, 0, 1, 'Головной офис', 'Толстого 2', '82223333333', 1),
       (2, 0, 1, 'Дополнительный офис', 'Горького 3', '83333223232', 1),
       (3, 0, 2, 'Головной офис', 'Советов 61', '81232222222', 1);

INSERT INTO Position (id, version, name)
VALUES (1, 0, 'Генеральный директор'),
       (2, 0, 'Бухгалтер'),
       (3, 0, 'Программист'),
       (4, 0, 'Менеджер по продажам'),
       (5, 0, 'Кассир');

INSERT INTO User (id, version, office_id, first_name, second_name, middle_name, position_id, document_id,
                  citizenship_id, phone,
                  is_identified)
VALUES (1, 0, 1, 'Иван', 'Иванов', 'Иванович', 1, 1, 1, '81111111111', 1),
       (2, 0, 1, 'Андрей', 'Андреев', 'Андреевич', 1, 2, 1, '84444444444', 1),
       (3, 0, 1, 'Петр', 'Петров', 'Петрович', 3, 3, 1, '85555555555', 1),
       (4, 0, 1, 'Игорь', 'Игорев', 'Игоревич', 1, 4, 1, '86666666666', 1),
       (5, 0, 2, 'Федор', 'Федоров', 'Федорович', 2, 5, 1, '87777777777', 1);