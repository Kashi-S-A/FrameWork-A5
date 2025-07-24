<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Expense List</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #eef1f5;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 40px;
      }

      h2 {
        color: #333;
        margin-bottom: 30px;
      }

      table {
        border-collapse: collapse;
        width: 80%;
        max-width: 800px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }

      th,
      td {
        padding: 12px 20px;
        text-align: left;
        border-bottom: 1px solid #ccc;
      }

      th {
        background-color: #007bff;
        color: white;
      }

      tr:hover {
        background-color: #f1f1f1;
      }

      .no-data {
        margin-top: 20px;
        color: #666;
      }
    </style>
  </head>
  <body>
    <h2>Expense List</h2>

    <table>
      <thead>
        <tr>
          <th>Expense Name</th>
          <th>Amount</th>
          <th>Description</th>
        </tr>
      </thead>
      <tbody>
        <!-- Sample static data -->
        <tr>
          <td>Groceries</td>
          <td>1500.00</td>
          <td>Weekly grocery shopping</td>
        </tr>
        <tr>
          <td>Electricity Bill</td>
          <td>850.75</td>
          <td>June month electricity payment</td>
        </tr>
        <tr>
          <td>Internet</td>
          <td>999.00</td>
          <td>Monthly broadband charges</td>
        </tr>
      </tbody>
    </table>
  </body>
</html>
