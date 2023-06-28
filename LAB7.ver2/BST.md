printInorder(node)
├─ Check if node is not null
│   ├─ Call printInorder(node.left)
│   │   ├─ Check if node.left is not null
│   │   │   └─ Call printInorder(node.left.left)
│   │   └─ Print "<-- " + node.left.data
│   ├─ Print "<-- " + node.data
│   └─ Call printInorder(node.right)
│       ├─ Check if node.right is not null
│       │   └─ Call printInorder(node.right.left)
│       └─ Print "<-- " + node.right.data
└─ Finish


