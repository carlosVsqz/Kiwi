import GUButton from '@components/control/gu-button';
import React, {useEffect} from 'react';
import Modal, {Props} from 'react-modal';
import {Formik} from "formik";
import * as Yup from 'yup';
import styled from "styled-components";
import HeaderTitleLine from "@components/other/header-title-line";

interface RegisterModalProps {
  height?: number | string;
  width?: number;
  onCancelClick?: () => void;
  onConfirmClick?: () => void;
}

interface RegisterFormProps {
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  password: string;
}

const FooterButtons = styled(GUButton)`
  font-size: 14px;
  color: #0065CAFF !important;
`;
const RegisterModal = ({
                      height = 'auto',
                      width = 400,
                      onCancelClick,
                      onConfirmClick,
                      ...props
                    }: RegisterModalProps & Props) => {
  useEffect(() => {
    Modal.setAppElement('#modal');
  }, []);

  const initialValues = {
    firstName: '',
    lastName: '',
    username: '',
    email: '',
    password: '',
  };

  const RegisterFormSchema = Yup.object().shape({
    firstName: Yup.string().required('Por favor, ingrese un nombre.'),
    lastName: Yup.string().required('Por favor, ingrese un apellido.'),
    username: Yup.string().required('Por favor, ingresa un nombre de usuario.'),
    email: Yup.string().required('Por favor, ingresa una dirección de email. '),
    password: Yup.string().required('Por favor, ingresa una contraseña.'),
  });



  const handleSubmitInfo = (val: RegisterFormProps) => {
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
          <h3 className="center mt-3">Registrate</h3>
        </div>
        <div className="container">
          <div className="login">
            <div className="login__form">
              <Formik initialValues={initialValues} onSubmit={handleSubmitInfo} validationSchema={RegisterFormSchema}>
                {({ values, handleChange, handleSubmit, errors, touched }) => (
                  <form onSubmit={handleSubmit}>
                    <div className="row">
                      <div className="col-12 col-sm-6">
                        <div className="input-group">
                          <input type="text" value={values.firstName} placeholder="Nombres" name="firstName" onChange={handleChange} />
                          {!!errors.firstName && !!touched.firstName && <span className="error">{errors.firstName}</span>}
                        </div>
                      </div>
                      <div className="col-12 col-sm-6">
                        <div className="input-group">
                          <input type="text" value={values.lastName} placeholder="Apellidos" name="lastName" onChange={handleChange} />
                          {!!errors.lastName && !!touched.lastName && <span className="error">{errors.lastName}</span>}
                        </div>
                      </div>
                    </div>

                    <div className="input-group">
                      <input type="text" value={values.username} placeholder="Nombre de usuario" name="username" onChange={handleChange} />
                      {!!errors.username && !!touched.username && <span className="error">{errors.username}</span>}
                    </div>

                    <div className="input-group">
                      <input type="email" value={values.email} placeholder="Correo electronico" name="email" onChange={handleChange} />
                      {!!errors.email && !!touched.email && <span className="error">{errors.email}</span>}
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
                        Únete
                      </GUButton>
                    </div>
                  </form>
                )}
              </Formik>
            </div>
          </div>
        </div>
        <div className="justify-content-center alert-modal-footer col-12 mb-3">
          <div className="row justify-content-center">
            <HeaderTitleLine className="col-md-12 mt-lg-n5 mb-lg-2" title=""/>
            Al registrarte, confirmas que aceptas los
            <FooterButtons shape="round" size="small" variant="link" href="/terminos-condiciones" onClick={onConfirmClick}>
              Términos y condiciones
            </FooterButtons>
            &nbsp;y la&nbsp;
            <FooterButtons shape="round" size="small" variant="link" href="/terminos-condiciones" onClick={onConfirmClick}>
              Política de privacidad
            </FooterButtons>
          </div>

        </div>
      </div>
    </Modal>
  );
};

export default RegisterModal;
