use QLNV

CREATE TABLE [Employees] (
  [id] nvarchar(255) PRIMARY KEY,
  [firstName] nvarchar(255) not null,
  [lastName] nvarchar(255) not null,
  [gender] nvarchar(255) not null,
  [birthDate] DATETIME not null,
  [phoneNumber] nvarchar(255) not null,
  [group] nvarchar(255) not null,
  [typeId] nvarchar(255) not null,
  [religion] nvarchar(255) not null,
  [degreeId] nvarchar(255) not null,
  [nation] nvarchar(255) not null,
  [positionId] nvarchar(255) not null,
  [departmentId] nvarchar(255) not null,
  [specialtyId] nvarchar(255) not null,
  [employStatus] bit not null,
  [status] bit not null
)
GO

CREATE TABLE [Account] (
  [userId] nvarchar(255) PRIMARY KEY,
  [username] nvarchar(255) not null,
  [password] nvarchar(255) not null,
  [email] nvarchar(255) not null,
  [avatar] nvarchar(255),
  [authorization] nvarchar(255) not null,
  [status] bit not null,
  [createdAt] DATETIME not null
)
GO

CREATE TABLE [EmployeeType] (
  [typeId] nvarchar(255) PRIMARY KEY,
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
  [positionSalary] nvarchar(255) not null,
  [createdAt] DATETIME not null,
  [updatedAt] DATETIME not null
)
GO

CREATE TABLE [Rewards] (
  [rewardId] nvarchar(255) PRIMARY KEY,
  [rewardName] nvarchar(255) not null,
  [reward] nvarchar(255) not null
)
GO

CREATE TABLE [Criticism] (
  [criticismId] nvarchar(255) PRIMARY KEY,
  [critismName] nvarchar(255) not null,
  [judgement] nvarchar(255) not null
)
GO

CREATE TABLE [EmployeesRewardsCriticism] (
  [employeeId] nvarchar(255),
  [rewardId] nvarchar(255),
  [critismId] nvarchar(255),
  [faultCount] integer not null,
  [createdAt] DATETIME,
  PRIMARY KEY ([employeeId], [rewardId], [critismId], [createdAt])
)
GO

CREATE TABLE [Specialties] (
  [specialtyId] nvarchar(255) PRIMARY KEY,
  [specialtyName] nvarchar(255) not null
)
GO

CREATE TABLE [SpecialtySalaries] (
  [specialtyId] nvarchar(255) PRIMARY KEY,
  [specialtySalary] nvarchar(255) not null,
  [createdAt] DATETIME not null,
  [updatedAt] DATETIME not null
)
GO

CREATE TABLE [EmployeeSalaries] (
  [employeeId] nvarchar(255),
  [advance] nvarchar(255) not null,
  [netSalary] nvarchar(255) not null,
  [createdAt] DATETIME not null
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
  [beginAt] DATETIME not null,
  [completedAt] DATETIME not null,
  [place] nvarchar(255) not null,
  [purpose] text
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

ALTER TABLE [EmployeeType] ADD FOREIGN KEY ([typeId]) REFERENCES [Employees] ([typeId])
GO

ALTER TABLE [Degrees] ADD FOREIGN KEY ([degreeId]) REFERENCES [Employees] ([degreeId])
GO

ALTER TABLE [Positions] ADD FOREIGN KEY ([positionId]) REFERENCES [Employees] ([positionId])
GO

ALTER TABLE [PositionSalaries] ADD FOREIGN KEY ([postionId]) REFERENCES [Positions] ([positionId])
GO

CREATE TABLE [Rewards_EmployeesRewardsCriticism] (
  [Rewards_rewardId] varchar,
  [EmployeesRewardsCriticism_rewardId] varchar,
  PRIMARY KEY ([Rewards_rewardId], [EmployeesRewardsCriticism_rewardId])
);
GO

ALTER TABLE [Rewards_EmployeesRewardsCriticism] ADD FOREIGN KEY ([Rewards_rewardId]) REFERENCES [Rewards] ([rewardId]);
GO

ALTER TABLE [Rewards_EmployeesRewardsCriticism] ADD FOREIGN KEY ([EmployeesRewardsCriticism_rewardId]) REFERENCES [EmployeesRewardsCriticism] ([rewardId]);
GO


CREATE TABLE [Criticism_EmployeesRewardsCriticism] (
  [Criticism_criticismId] varchar,
  [EmployeesRewardsCriticism_critismId] varchar,
  PRIMARY KEY ([Criticism_criticismId], [EmployeesRewardsCriticism_critismId])
);
GO

ALTER TABLE [Criticism_EmployeesRewardsCriticism] ADD FOREIGN KEY ([Criticism_criticismId]) REFERENCES [Criticism] ([criticismId]);
GO

ALTER TABLE [Criticism_EmployeesRewardsCriticism] ADD FOREIGN KEY ([EmployeesRewardsCriticism_critismId]) REFERENCES [EmployeesRewardsCriticism] ([critismId]);
GO


ALTER TABLE [EmployeesRewardsCriticism] ADD FOREIGN KEY ([employeeId]) REFERENCES [Employees] ([id])
GO

ALTER TABLE [SpecialtySalaries] ADD FOREIGN KEY ([specialtyId]) REFERENCES [Specialties] ([specialtyId])
GO

ALTER TABLE [Specialties] ADD FOREIGN KEY ([specialtyId]) REFERENCES [Employees] ([specialtyId])
GO

ALTER TABLE [EmployeeSalaries] ADD FOREIGN KEY ([employeeId]) REFERENCES [Employees] ([id])
GO

ALTER TABLE [Departments] ADD FOREIGN KEY ([departmentId]) REFERENCES [Employees] ([departmentId])
GO

ALTER TABLE [Employees] ADD FOREIGN KEY ([id]) REFERENCES [Departments] ([departmentLeader])
GO

ALTER TABLE [Departments] ADD FOREIGN KEY ([departmentId]) REFERENCES [BusinessTravels] ([businessTravelId])
GO

ALTER TABLE [Employees] ADD FOREIGN KEY ([id]) REFERENCES [Assignments] ([employeeId])
GO

ALTER TABLE [BusinessTravels] ADD FOREIGN KEY ([businessTravelId]) REFERENCES [Assignments] ([businessTravelId])
GO
