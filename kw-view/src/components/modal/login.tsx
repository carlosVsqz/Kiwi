import GUButton from '@components/control/gu-button';
import React, {useEffect} from 'react';
import Modal, {Props} from 'react-modal';
import {Formik} from "formik";
import * as Yup from 'yup';

interface AlertModalProps {
  height?: number | string;
  width?: number;
  onCancelClick?: () => void;
  onConfirmClick?: () => void;
}

interface LoginFormProps {
  emailOrUsername: string;
  password: string;
}

const LoginModal = ({
                      height = 'auto',
                      width = 400,
                      onCancelClick,
                      onConfirmClick,
                      ...props
                    }: AlertModalProps & Props) => {
  useEffect(() => {
    Modal.setAppElement('#modal');
  }, []);

  const initialValues = {
    emailOrUsername: '',
    password: '',
  };

  const ContactFormSchema = Yup.object().shape({
    emailOrUsername: Yup.string().required('Por favor ingrese un correo electronico valido o un nombre de usuario'),
    password: Yup.string().required('Contraseña requerida'),
  });

  const handleSubmitInfo = (val: LoginFormProps) => {
    console.log(val);
  };

  return (
    <Modal
      style={{
        overlay: {
          zIndex: 1000,
        },
        content: {
          border: 0,
          height: height,
          width: width,
          top: '50%',
          left: '50%',
          right: 'auto',
          bottom: 'auto',
          marginRight: '-50%',
          boxShadow: '0px 0px 16px 0px rgb(0 0 0 / 8%)',
          transform: 'translate(-50%, -50%)',
        },
      }}
      contentLabel="Modal"
      {...props}>
      <div className="alert-modal">

        <div className="alert-modal-header">
            <GUButton onClick={onCancelClick}><i className="fas fa-times"/></GUButton>
          <h3 className="center mt-3">Bienvenido nuevamente</h3>
        </div>
        <div className="container">
          <div className="login">
            <div className="login__form">
              <Formik initialValues={initialValues} onSubmit={handleSubmitInfo} validationSchema={ContactFormSchema}>
                {({ values, handleChange, handleSubmit, errors, touched }) => (
                  <form onSubmit={handleSubmit}>
                    <div className="input-group">
                      <input type="text" value={values.emailOrUsername} placeholder="Nombre de usuario o correo electronico" name="emailOrUsername" onChange={handleChange} />
                      {!!errors.emailOrUsername && !!touched.emailOrUsername && <span className="error">{errors.emailOrUsername}</span>}
                    </div>
                    <div className="input-group">
                      <input
                        type="password"
                        value={values.password}
                        placeholder="Contraseña"
                        name="password"
                        onChange={handleChange}
                      />
                      {!!errors.password && !!touched.password && <span className="error">{errors.password}</span>}
                    </div>

                    <div className="center">
                      <GUButton className="col-12" shape="round" size="small" variant="contained" color="primary" buttonType="submit" onClick={onConfirmClick}>
                        Ingresar
                      </GUButton>
                    </div>
                  </form>
                )}
              </Formik>
            </div>
          </div>
        </div>
        <div className="justify-content-center alert-modal-footer col-12">
        </div>
      </div>
    </Modal>
  );
};

export default LoginModal;
