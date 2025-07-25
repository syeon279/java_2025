#################################################
# 1. List : 순서대로 담아요(기차) [ "곰인형", "자동차", "로봇" ]
# 2. Tuple : 바뀌지 않는 생일 달력 ("1월", "2월", "3월")
# 3. 딕셔너리 : 이름표가 붙은 물건들 {"사과" : "빨강", "바나나" : "노랑"}
# 4. set : 같은건 하나만! 중복 x {"딸기", "딸기", "포도"} → {"딸기", "포도"}

# List [{},{},{}]
toys = [ "곰인형", "자동차", "로봇" ] #append, remove
toys.append("퍼즐")
print(toys)

toys.remove("자동차")
print(toys)
print(toys[1])

# Tuple
months=("1월", "2월", "3월")
#months[1] = "4월"
#print(months) #TypeError: 'tuple' object does not support item assignment
print(months[1])

# 딕셔너리 {"사과" : "빨강", "바나나" : "노랑"}
colors = {"사과" : "빨강", "바나나" : "노랑"}
print(colors)
colors["바나나"] = "초록"
print(colors)

# set {"딸기", "딸기", "포도"} → {"딸기", "포도"}
fruits = {"딸기", "딸기", "포도"}
print(fruits)