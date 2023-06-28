printInorder(node)<br>
├─ Check if node is not null<br>
│   ├─ Call printInorder(node.left)<br>
│   │   ├─ Check if node.left is not null<br>
│   │   │   └─ Call printInorder(node.left.left)<br>
│   │   └─ Print "<-- " + node.left.data<br>
│   ├─ Print "<-- " + node.data<br>
│   └─ Call printInorder(node.right)<br>
│       ├─ Check if node.right is not null<br>
│       │   └─ Call printInorder(node.right.left)<br>
│       └─ Print "<-- " + node.right.data<br>
└─ Finish<br>


