use QLNV

CREATE TABLE [Employees] (
  [id] nvarchar(255) PRIMARY KEY,
  [fullName] nvarchar(255) not null,
  [gender] nvarchar(255) not null,
  [birthDate] DATE not null,
  [phoneNumber] nvarchar(255) not null,
  [ethnicGroup] nvarchar(255) not null,
  [typeId] nvarchar(255) not null,
  [religion] nvarchar(255) not null,
  [degreeId] nvarchar(255) not null,
  [nation] nvarchar(255) not null,
  [positionId] nvarchar(255) not null,
  [departmentId] nvarchar(255) not null,
  [specialtyId] nvarchar(255) not null,
  [employStatus] bit not null,
)
GO


CREATE TABLE [Account] (
  [userId] nvarchar(255) PRIMARY KEY,
  [username] nvarchar(255) not null,
  [password] nvarchar(255) not null,
  [email] nvarchar(255) not null,
  [avatar] nvarchar(255),
  [authorization] nvarchar(255) not null,
  [createdAt] DATETIME not null
)
GO

CREATE TABLE [EmployeeType] (
  [typeId] nvarchar(255) PRIMARY KEY ,
  [typeName] nvarchar(255) not null
)
GO

CREATE TABLE [Degrees] (
  [degreeId] nvarchar(255) PRIMARY KEY,
  [degreeName] nvarchar(255) not null
)
GO

CREATE TABLE [Positions] (
  [positionId] nvarchar(255) PRIMARY KEY,
  [positionName] nvarchar(255) not null
)
GO

CREATE TABLE [PositionSalaries] (
  [postionId] nvarchar(255) PRIMARY KEY,
  [positionSalaryAllowance] numeric(5,3) not null,
  [createdAt] DATETIME not null,
  [updatedAt] DATETIME not null
)
GO

CREATE TABLE [Rewards] (
  [rewardId] nvarchar(255) PRIMARY KEY,
  [rewardName] nvarchar(255) not null,
  [reward] int not null
)
GO

CREATE TABLE [Criticism] (
  [criticismId] nvarchar(255) PRIMARY KEY,
  [critismName] nvarchar(255) not null,
  [judgement] int not null
)
GO

CREATE TABLE [EmployeesRewardsCriticism] (
  [employeeId] nvarchar(255),
  [rewardId] nvarchar(255),
  [criticismId] nvarchar(255),
  [faultCount] integer not null,
  [rewardCount] integer not null,
  [createdAt] DATE,
  PRIMARY KEY ([employeeId], [rewardId], [criticismId], [createdAt])
)
GO

CREATE TABLE [Specialties] (
  [specialtyId] nvarchar(255) PRIMARY KEY,
  [specialtyName] nvarchar(255) not null,
  [baseSalary] int not null
)
GO

CREATE TABLE [EmployeeSalaries] (
  [employeeId] nvarchar(255),
  [advance] int not null,
  [insurance] decimal not null,
  [netSalary] decimal not null,
  [createdAt] DATETIME not null,
  PRIMARY KEY ([employeeId], [createdAt])
)
GO

CREATE TABLE [Departments] (
  [departmentId] nvarchar(255) PRIMARY KEY,
  [departmentName] nvarchar(255) not null,
  [departmentLeader] nvarchar(255) not null
)
GO

CREATE TABLE [BusinessTravels] (
  [businessTravelId] nvarchar(255) PRIMARY KEY,
  [departmentId] nvarchar(255) not null,
  [beginAt] DATETIME not null,
  [completedAt] DATETIME not null,
  [place] nvarchar(255) not null,
  [purpose] nvarchar(max)
)
GO

CREATE TABLE [Assignments] (
  [employeeId] nvarchar(255),
  [businessTravelId] nvarchar(255),
  PRIMARY KEY ([employeeId], [businessTravelId])
)
GO

ALTER TABLE [Account] ADD FOREIGN KEY ([userId]) REFERENCES [Employees] ([id])
GO

ALTER TABLE [Employees] ADD FOREIGN KEY ([typeId]) REFERENCES [EmployeeType] ([typeId])
GO

ALTER TABLE [Employees] ADD FOREIGN KEY ([degreeId]) REFERENCES [Degrees] ([degreeId])
GO

ALTER TABLE [Employees] ADD FOREIGN KEY ([positionId]) REFERENCES [Positions] ([positionId])
GO

ALTER TABLE [PositionSalaries] ADD FOREIGN KEY ([postionId]) REFERENCES [Positions] ([positionId])
GO

ALTER TABLE [EmployeesRewardsCriticism] ADD FOREIGN KEY ([rewardId]) REFERENCES [Rewards] ([rewardId]);
GO

ALTER TABLE [EmployeesRewardsCriticism] ADD FOREIGN KEY ([criticismId]) REFERENCES [Criticism] ([criticismId]);
GO


ALTER TABLE [EmployeesRewardsCriticism] ADD FOREIGN KEY ([employeeId]) REFERENCES [Employees] ([id])
GO


ALTER TABLE [Employees] ADD FOREIGN KEY ([specialtyId]) REFERENCES [Specialties] ([specialtyId])
GO

ALTER TABLE [EmployeeSalaries] ADD FOREIGN KEY ([employeeId]) REFERENCES [Employees] ([id])
GO

ALTER TABLE [Employees] ADD FOREIGN KEY ([departmentId]) REFERENCES [Departments] ([departmentId])
GO

ALTER TABLE [Departments] ADD FOREIGN KEY ([departmentLeader]) REFERENCES [Employees] ([id])
GO

ALTER TABLE [BusinessTravels] ADD FOREIGN KEY ([departmentId]) REFERENCES [Departments] ([departmentId])
GO

ALTER TABLE [Assignments] ADD FOREIGN KEY ([employeeId]) REFERENCES [Employees] ([id])
GO

ALTER TABLE [Assignments] ADD FOREIGN KEY ([businessTravelId]) REFERENCES [BusinessTravels] ([businessTravelId])
GO
