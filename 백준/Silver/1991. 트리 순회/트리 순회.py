import sys

n = int(sys.stdin.readline())
l = [None]*26
r = [None]*26

for _ in range(n):
    node, left, right = map(str, sys.stdin.readline().split())
    if left != '.': l[ord(node)-ord('A')] = left
    if right != '.': r[ord(node)-ord('A')] = right

pre_ = []
in_ = []
post_ = []

def pre_order(root):
    if root is None: return
    pre_.append(root)
    pre_order(l[ord(root)-ord('A')])
    pre_order(r[ord(root)-ord('A')])

def in_order(root):
    if root is None: return
    in_order(l[ord(root)-ord('A')])
    in_.append(root)
    in_order(r[ord(root)-ord('A')])

def post_order(root):
    if root is None: return
    post_order(l[ord(root)-ord('A')])
    post_order(r[ord(root)-ord('A')])
    post_.append(root)

pre_order('A')
in_order('A')
post_order('A')

print(''.join(pre_))
print(''.join(in_))
print(''.join(post_))