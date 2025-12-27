import sys

input = sys.stdin.readline

class Student:
    def __init__(self, ID, name, toan, ly, hoa, course, class_name):
        self.ID = ID
        self.name = name
        self.toan = toan
        self.ly = ly
        self.hoa = hoa
        self.course = course
        self.class_name = class_name
        self.total = toan + ly + hoa

    def __lt__(self, other):
        if self.total != other.total:
            return self.total > other.total
        return self.ID < other.ID

    def __str__(self):
        return f"{self.ID} {self.name} {self.total:.2f} {self.class_name} {self.course}"


T = int(input())

for case_idx in range(1, T + 1):
    N = int(input())
    students = []

    for _ in range(N):
        parts = input().strip().split()

        ID = parts[0]
        class_name = parts[-1]
        course = int(parts[-2])
        hoa = float(parts[-3])
        ly = float(parts[-4])
        toan = float(parts[-5])
        name = ' '.join(parts[1:-5])

        students.append(Student(ID, name, toan, ly, hoa, course, class_name))

    students.sort()

    print(f"Case #{case_idx}:")
    for student in students:
        print(student)
