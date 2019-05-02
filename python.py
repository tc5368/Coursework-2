def removeStopwords(filename):
	f = open(filename,'r'); w = open('stopwords.txt','r')
	gp = f.read().split('\n'); sw = w.read().split('\n')
	all_gp = []
	for section in gp:
		a = section.split(' ')
		for w in a:
			if w != '':
				all_gp.append(w)
	valid = []
	for w in all_gp:
		if w.lower() not in sw:
			valid.append(w.lower())
	return valid

def mergeSort(x):
	result = []
	if len(x) < 2:
		return x
	mid = len(x)//2
	y = mergeSort(x[:mid])
	z = mergeSort(x[mid:])
	while (len(y) > 0) or (len(z) > 0):
		if len(y) > 0 and len(z) > 0:
			if y[0] > z[0]:
				result.append(z[0])
				z.pop(0)
			else:
				result.append(y[0])
				y.pop(0)
		elif len(z) > 0:
			for i in z:
				result.append(i)
				z.pop(0)
		else:
			for i in y:
				result.append(i)
				y.pop(0)
	return result

def insertionSort(alist):
	c = 0
	s = 0
	for i in range(1,len(alist)):
		currentvalue = alist[i]
		s += 1
		position = i
		while position>0 and alist[position-1]>currentvalue:
			c += 1
			s += 1
			alist[position]=alist[position-1]
			position -= 1
		alist[position]=currentvalue
		s +=1 
		c +=1
	print(c,s)
	return alist

def main():
	a = removeStopwords('GPT2.txt')
	a = mergeSort(a)
	print(a)
	a = removeStopwords('GPT2.txt')
	a = insertionSort(a)
	print(a)

class circularQueue():
	def __init__(self,size):
		self.size = size
		self.data = [' ']*self.size
		self.fpointer = 0
		self.rpointer = 0

	def enqueue(self,toAdd):
		if self.isSpace() == False: 
			print('Stack Overflow')
		else:
			self.data[self.rpointer] = toAdd
			self.rpointer += 1
			if self.rpointer == self.size:
				self.rpointer = 0

	def dequeue(self):
		if self.isEmpty():
			print('Stack Underflow')
		else:
			toReturn = self.data[self.fpointer]
			self.data[self.fpointer] = ' '
			self.fpointer += 1
			if self.fpointer == self.size:
				self.rpointer = 0
			return toReturn

	def isEmpty(self):
		for i in self.data:
			if i != ' ':
				return False
		return True

	def isSpace(self):
		for i in self.data:
			if i == ' ':
				return True
		return False

	def getRearElement(self):
		return self.data[self.rpointer]

	def getFrontElement(self):
		return self.data[self.fpointer]






