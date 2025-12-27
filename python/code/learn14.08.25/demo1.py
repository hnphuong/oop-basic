list1 = ['1','2','3','mai']
print('list1: ', list1)
print(type(list1))
print(f'Hello {list1[3]}!')
list1[3] = 'Hà'
print(list1)
list1.append('Lieen')
print(list1)
list1.insert(4, 'Nhung')
print(list1)
del list1[2]
print(list1)
last_item = list1.pop()
print(last_item)
list1.remove('2')
print(list1)
list1.insert(5, '2')
sorted_list=sorted(list1)
print(list1)
for item in list1:
    print(f"value: ", item)

list2 = list(range(1,101,5))
print(list2)
print("--------------------")
list3 = [value**3 for value in range(0,21)]
print(list3)
print(list3[8:])
print(list3[5:8])