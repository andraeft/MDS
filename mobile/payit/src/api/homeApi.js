const initHome = () =>
  new Promise((resolve) => {
    setTimeout(() => resolve({ message: 'Hello, World!' }), 3000);
  });

export default initHome;
