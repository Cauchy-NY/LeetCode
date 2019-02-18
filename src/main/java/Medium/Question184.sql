# 第一个想到的是用 group by
SELECT D.Name AS Department ,E.Name AS Employee ,E.Salary
from
	Employee E,
	Department D
WHERE E.DepartmentId = D.id
  AND (DepartmentId,Salary) in
  (SELECT DepartmentId,max(Salary) as max FROM Employee GROUP BY DepartmentId);

# 其他方法
SELECT D.Name AS Department ,E.Name AS Employee ,E.Salary
FROM
	Employee E,
	(SELECT DepartmentId,max(Salary) as max FROM Employee GROUP BY DepartmentId) T,
	Department D
WHERE E.DepartmentId = T.DepartmentId
  AND E.Salary = T.max
  AND E.DepartmentId = D.id;

SELECT D.Name AS Department ,A.Name AS Employee ,A.Salary
FROM
	Employee A,
	Department D
WHERE A.DepartmentId = D.Id
  AND NOT EXISTS
  (SELECT 1 FROM Employee B WHERE B.Salary > A.Salary AND A.DepartmentId = B.DepartmentId);