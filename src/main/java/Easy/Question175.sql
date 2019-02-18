# 几种正确写法
# basic left join
SELECT FirstName, LastName, City, State
FROM Person
LEFT JOIN Address
ON Person.PersonId = Address.PersonId;

# left join + using
SELECT FirstName, LastName, City, State
FROM Person
LEFT JOIN Address
USING(PersonId);

# natural left join
SELECT FirstName, LastName, City, State
FROM Person
NATURAL LEFT JOIN Address;

# 错误，题目要求没有地址纪录但有姓名的也要查询出来，叉乘会忽略这一点
select p.FirstName, p.LastName, a.City, a. State
from Person p, Address a
where p.PersonId = a.PersonId;