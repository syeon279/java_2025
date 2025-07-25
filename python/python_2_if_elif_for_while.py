# 제어문
# 1. if
weather = "비"
if   weather== "비" :    #== 같다
  print("우산써요")
  
if   weather== "해" :    #== 같다
  print("아이스크림먹어요") 
elif weather== "비" :   
  print("우산써요")
else : 
  print("구름이 있어요")    


#2. for
#   한개씩   (영역)어디에서꺼내오세요
for  i  in  range(1,11) :  # 1~10  11전까지
  print(i , end=" ")
  
#2-1.  1  2  3  
print()
for  i in  range(1,4) : 
  print(i , end=" ")
  
#2-2.  안녕이라는 문자열   안   녕 
print()
for  i in  "안녕" : 
  print(i , end="*")
  
#3. while
i = 1   # 초기
while i<4 :  #조건
  print(i)
  i=i+1  # 증감
  
#3-1. 3 2 1  
i = 3
while i>0:
  print(i, end="")
  i-=1
  
#4. break, continue
print()
for i in range(4) : #0 1 2 3
  if i == 2:
    break  #나가
  print(i, end="")
  
  print()
for i in range(4) : #0 1 2 3
  if i == 2:
    continue #건너뛰기
  print(i, end="")

#5. while True:
while True :
  answer = input("종료하려면 q를 입력하세요: ")
  if answer == 'q':
    print("종료합니다.")
    break