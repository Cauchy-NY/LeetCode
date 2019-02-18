# simply but ugly
Select DISTINCT l1.Num as ConsecutiveNums from Logs l1, Logs l2, Logs l3
where l1.Id=l2.Id-1 and l2.Id=l3.Id-1 and l1.Num=l2.Num and l2.Num=l3.Num;

# 后面一种看起来直白一点
select DISTINCT num as ConsecutiveNums FROM
  (select num,
          case
            when @record = num then @count:=@count+1
            when @record <> @record:=num then @count:=1 end as n
   from
     Logs ,(select @count:=0, @record:=(SELECT num from Logs limit 0,1)) r
  ) a
where a.n>=3;

select distinct Num as ConsecutiveNums
from (
  select Num,
         case
            when @prev = Num then @count := @count + 1
            when (@prev := Num) is not null then @count := 1
            end as CNT
  from Logs, (select @prev := null,@count := null) as t
) as temp
where temp.CNT >= 3;