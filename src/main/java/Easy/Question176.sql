# 在这道题里面当然第一种比第二种快很多，因为第一种只用找最大，第二种要排序
# 皮的一*
SELECT max(Salary) as SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT max(Salary) FROM Employee);
# 这是一个通用的写法，limit + offset 可以进行范围查询
select (
  select distinct Salary from Employee order by Salary Desc limit 1 offset 1
) as SecondHighestSalary;